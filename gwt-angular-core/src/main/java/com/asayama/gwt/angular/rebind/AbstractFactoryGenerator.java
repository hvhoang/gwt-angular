package com.asayama.gwt.angular.rebind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.Injectable;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.rebind.JClassTypeUtils;
import com.asayama.gwt.rebind.JMethodUtils;
import com.asayama.gwt.rebind.exceptions.RebindException;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JType;

abstract class AbstractFactoryGenerator extends AbstractGenerator {

    private static final String CLASS = AbstractFactoryGenerator.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    @Override
    public String generate(TreeLogger logger, GeneratorContext context, String qualifiedClassName) throws UnableToCompleteException {
        
        final String METHOD = "generate(TreeLogger, GeneratorContext, String)";

        JClassType classType = getClassType(context, qualifiedClassName);
        String packageName = classType.getPackage().getName();
        String className = classType.getSimpleSourceName();
        JClassType supportedRootClassType = getSupportedRootClassType(classType);
        List<JClassType> supportedClassTypes = getSupportedClassTypes(supportedRootClassType);

        VelocityGenerator velocity = new VelocityGenerator(getFilename());
        velocity.put("classType", classType);
        velocity.put("packageName", packageName);
        velocity.put("className", className);
        velocity.put("supportedRootClassType", supportedRootClassType.getQualifiedSourceName());
        velocity.put("supportedClassTypes", supportedClassTypes);

        // Helpers
        velocity.put("JClassTypeUtils", JClassTypeUtils.class);
        velocity.put("JMethodUtils", JMethodUtils.class);
        velocity.put("Injectable", Injectable.class);

        Map<JClassType, List<Field>> classTypeFields = new HashMap<JClassType, List<Field>>();
        for (JClassType supportedClassType : supportedClassTypes) {
            List<Field> fieldList = new ArrayList<Field>();
            for (JClassType supportedSuperClassType : supportedClassType.getFlattenedSupertypeHierarchy()) {
                JField[] fields = supportedSuperClassType.getFields();
                if (fields == null) {
                    continue;
                }
                for (JField field : fields) {
                    String cname = supportedSuperClassType.getQualifiedSourceName();
                    String dependency = null;
                    if (JClassTypeUtils.supports(field.getType(), NGObject.class)) {
                        Bind bind = field.getType().isClass().getAnnotation(Bind.class);
                        dependency = bind.value();
                    } else if (JClassTypeUtils.supports(field.getType(), Injectable.class)) {
                        dependency = field.getType().getQualifiedSourceName();
                    }
                    String name = field.getName();
                    fieldList.add(new Field(field, cname, dependency, name));
                }
            }
            classTypeFields.put(supportedClassType, fieldList);
        }
        velocity.put("classTypeFields", classTypeFields);

        // Identify dependencies of each supported type
        List<String[]> dependencies = new ArrayList<String[]>();
        for (JClassType supportedClassType : supportedClassTypes) {
            JField[] fields = supportedClassType.getFields();
            List<String> names = new ArrayList<String>();
            // https://github.com/kyoken74/gwt-angular/issues/14
            // We need to inject super types' injectables as well
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
            dependencies.add(names.toArray(EMPTY_STRING_ARRAY));
        }
        velocity.put("dependencies", dependencies);

        return generate(logger, context, velocity, packageName, className);
    }

    protected JClassType getSupportedRootClassType(JClassType classType) {
        
        final String METHOD = "getSupportedRootClassType(JClassType)";
        
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
            String m = "Unable to find the supported root classType for " + classType;
            LOG.logp(Level.SEVERE, CLASS, METHOD, m);
            throw new RebindException(m);
        }
        return supportedRootClassType;
    }
    
    protected List<JClassType> getSupportedClassTypes(JClassType supportedRootClassType) {
        
        final String METHOD = "getSupportedSubClassTypes(JClassType)";
        
        JClassType[] supportedSubClassTypes = supportedRootClassType.getSubtypes();
        List<JClassType> supportedClassTypes = new ArrayList<JClassType>();
        if (supportedSubClassTypes == null || supportedSubClassTypes.length == 0) {
            String m = "Unable to find supported sub classTypes for " + supportedRootClassType;
            LOG.logp(Level.SEVERE, CLASS, METHOD, m);
            throw new RebindException(m);
        }
        for (JClassType returnClassType : supportedSubClassTypes) {
            if (returnClassType.isDefaultInstantiable()) {
                supportedClassTypes.add(returnClassType);
            }
        }
        return supportedClassTypes;
    }
}
