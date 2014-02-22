package com.asayama.gwt.angular.rebind;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.asayama.gwt.angular.client.Injectable;
import com.asayama.gwt.angular.client.Module;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.client.annotations.Depends;
import com.asayama.gwt.rebind.JClassTypeUtils;
import com.asayama.gwt.rebind.JMethodUtils;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.TypeOracle;

abstract class AbstractGenerator extends Generator {

    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    abstract String getFilename();

    abstract String getSuffix();

    @Override
    public String generate(TreeLogger logger, GeneratorContext context,
            String qualifiedName) throws UnableToCompleteException {

        try {
            final String filename = getFilename();
            VelocityGenerator velocity = new VelocityGenerator(filename);
            velocity.put("templateFilename", filename);
            velocity.put("logger", logger);
            velocity.put("context", context);
            velocity.put("qualifiedName", qualifiedName);

            TypeOracle typeOracle = context.getTypeOracle();
            JClassType classType = typeOracle.getType(qualifiedName);
            velocity.put("classType", classType);

            if (classType.isInterface() == null) {
                return qualifiedName;
            }

            // Define basic characteristics of the generated type.
            String packageName = classType.getPackage().getName();
            String simpleName = classType.getSimpleSourceName();
            String generatedQualifiedName = packageName + "." + simpleName + getSuffix();
            String generatedSimpleName = simpleName + getSuffix();
            velocity.put("packageName", packageName);
            velocity.put("simpleName", simpleName);
            velocity.put("generatedQualifiedName", generatedQualifiedName);
            velocity.put("generatedSimpleName", generatedSimpleName);

            // Find the public create(Class<T>) method's return type
            JClassType parameterClassType = null;
            JMethod[] methods = classType.getInheritableMethods();
            for (JMethod method : methods) {
                JType[] parameterTypes = method.getParameterTypes();
                if (parameterTypes == null || parameterTypes.length == 0) {
                    continue;
                }
                parameterClassType = parameterTypes[0].isClassOrInterface();
                if (parameterClassType != null) {
                    break;
                }
//                for (JType parameterType : parameterTypes) {
//                    if (!JClassTypeUtils.supports(parameterType, Class.class)) {
//                        continue;
//                    }
//                    JClassType[] parameterClassTypes = parameterType.isParameterized().getTypeArgs();
//                    if (parameterClassTypes != null && parameterClassTypes.length == 1) {
//                        parameterClassType = parameterClassTypes[0];
//                    }
//                }
            }

            if (parameterClassType == null) {
                return qualifiedName;
            }

            // Find all the subtypes of this return type
            JClassType[] returnClassTypes = parameterClassType.getSubtypes();
            List<JClassType> returnClassTypeList = new ArrayList<JClassType>();
            if (returnClassTypes == null || returnClassTypes.length == 0) {
                return qualifiedName;
            }
            for (JClassType returnClassType : returnClassTypes) {
                if (returnClassType.isDefaultInstantiable()) {
                    returnClassTypeList.add(returnClassType);
                }
            }
            velocity.put("parameterClassType", parameterClassType.getQualifiedSourceName());
            velocity.put("returnClassTypes", returnClassTypeList);

            // Find the dependency of all return types
            List<String[]> dependencies = new ArrayList<String[]>();
            for (JClassType returnClassType : returnClassTypeList) {
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
            PrintWriter wrier = context.tryCreate(logger, packageName, generatedSimpleName);
            if (wrier != null) {
                velocity.merge(wrier);
                context.commit(logger, wrier);
            }
            return generatedQualifiedName;

        } catch (Exception e) {
            e.printStackTrace();
            return qualifiedName;
        }

    }
}
