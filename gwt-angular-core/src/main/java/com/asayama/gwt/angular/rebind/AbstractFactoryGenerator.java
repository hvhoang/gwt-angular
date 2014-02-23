package com.asayama.gwt.angular.rebind;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.Injectable;
import com.asayama.gwt.angular.client.Module;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.client.annotations.Depends;
import com.asayama.gwt.rebind.JClassTypeUtils;
import com.asayama.gwt.rebind.JMethodUtils;
import com.asayama.gwt.rebind.exceptions.RebindException;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.TypeOracle;

abstract class AbstractFactoryGenerator extends Generator {

    private static final String CLASS = AbstractFactoryGenerator.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    abstract String getFilename();

    @Override
    public String generate(TreeLogger logger, GeneratorContext context, String qualifiedClassName) throws UnableToCompleteException {
        
        final String METHOD = "generate(TreeLogger, GeneratorContext, String)";

        try {
            String templateFilename = getFilename();
            TypeOracle typeOracle = context.getTypeOracle();
            JClassType classType = typeOracle.getType(qualifiedClassName);
            String packageName = classType.getPackage().getName();
            String className = classType.getSimpleSourceName();
            
            if (classType.isInterface() == null) {
                String m = className + " must be an interface";
                LOG.logp(Level.SEVERE, CLASS, METHOD, m);
                throw new RebindException(m);
            }

            VelocityGenerator velocity = new VelocityGenerator(templateFilename);
            velocity.put("templateFilename", templateFilename);
            velocity.put("classType", classType);
            velocity.put("packageName", packageName);
            velocity.put("className", className);
//            velocity.put("qualifiedClassName", qualifiedClassName);

            // Find the type Factory supports
            JClassType supportedRootClassType = null;
            JMethod[] methods = classType.getInheritableMethods();
            for (JMethod method : methods) {
                JType[] parameterTypes = method.getParameterTypes();
                if (parameterTypes == null || parameterTypes.length == 0) {
                    continue;
                }
                supportedRootClassType = parameterTypes[0].isClassOrInterface();
                if (supportedRootClassType != null) {
                    break;
                }
            }

            if (supportedRootClassType == null) {
                return qualifiedClassName;
            }

            // Find all the subtypes of this return type
            JClassType[] supportedSubClassTypes = supportedRootClassType.getSubtypes();
            List<JClassType> supportedClassTypes = new ArrayList<JClassType>();
            if (supportedSubClassTypes == null || supportedSubClassTypes.length == 0) {
                return qualifiedClassName;
            }
            for (JClassType returnClassType : supportedSubClassTypes) {
                if (returnClassType.isDefaultInstantiable()) {
                    supportedClassTypes.add(returnClassType);
                }
            }
            velocity.put("supportedRootClassType", supportedRootClassType.getQualifiedSourceName());
            velocity.put("supportedClassTypes", supportedClassTypes);

            // Find the dependency of all return types
            List<String[]> dependencies = new ArrayList<String[]>();
            for (JClassType returnClassType : supportedClassTypes) {
                JField[] fields = returnClassType.getFields();
                List<String> names = new ArrayList<String>();
                for (JField field : fields) {
                    JClassType fieldClassType = field.getType().isClassOrInterface();
                    if (JClassTypeUtils.supports(fieldClassType, NGObject.class)) {
                        Bind bind = fieldClassType.getAnnotation(Bind.class);
                        String name = bind.value();
                        names.add(name);
                    } else if (JClassTypeUtils.supports(fieldClassType, Injectable.class)) {
                        String name = fieldClassType.getQualifiedSourceName();
                        names.add(name);
                    }
                }
                if (JClassTypeUtils.supports(returnClassType, Module.class)) {
                    Depends depends = returnClassType.getAnnotation(Depends.class);
                    String[] ng = depends == null ? null : depends.ng();
                    if (ng != null) {
                        for (String n : ng) {
                            names.add(n);
                        }
                    }
                    Class<?>[] nc = depends.value();
                    if (nc != null) {
                        for (Class<?> c : nc) {
                            names.add(c.getName());
                        }
                    }
                }
                dependencies.add(names.toArray(EMPTY_STRING_ARRAY));
            }
            velocity.put("dependencies", dependencies);

            // Helpers
            velocity.put("JClassTypeUtils", JClassTypeUtils.class);
            velocity.put("JMethodUtils", JMethodUtils.class);
            velocity.put("Injectable", Injectable.class);

            // Generate type
            PrintWriter wrier = context.tryCreate(logger, packageName, "__" + className);
            if (wrier != null) {
                velocity.merge(wrier);
                context.commit(logger, wrier);
            }
            return packageName + ".__" + className;

        } catch (Exception e) {
            e.printStackTrace();
            return qualifiedClassName;
        }

    }
}
