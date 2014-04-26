package com.asayama.gwt.angular.rebind;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.client.Injectable;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.rebind.util.ClassTypeFields;
import com.asayama.gwt.angular.rebind.util.Field;
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

    @Override
    public String generate(TreeLogger logger, GeneratorContext context, String qualifiedClassName) throws UnableToCompleteException {
        
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
        velocity.put("JMethodUtils", JMethodUtils.class);

        ClassTypeFields classTypeFields = new ClassTypeFields();
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
                    Bind bind = field.getAnnotation(Bind.class);
                    if (bind != null) {
                        //direct annotation supersedes other criteria
                        dependency = bind.value();
                    } else if (JClassTypeUtils.supports(field.getType(), NGObject.class)) {
                        bind = field.getType().isClass().getAnnotation(Bind.class);
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
            String m = "Unable to find the supportedRootClassType for " + classType;
            LOG.logp(Level.SEVERE, CLASS, METHOD, m);
            throw new RebindException(m);
        }
        return supportedRootClassType;
    }
    
    protected List<JClassType> getSupportedClassTypes(JClassType supportedRootClassType) {
        
        final String METHOD = "getSupportedSubClassTypes(JClassType)";
        
        JClassType[] supportedSubClassTypes = supportedRootClassType.getSubtypes();
        List<JClassType> supportedClassTypes = new ArrayList<JClassType>();
        if (supportedSubClassTypes != null) {
            for (JClassType returnClassType : supportedSubClassTypes) {
                if (returnClassType.isDefaultInstantiable()) {
                    supportedClassTypes.add(returnClassType);
                }
            }
        }
        if (supportedClassTypes.size() == 0) {
            String m = "Unable to find supportedClassTypes for " + supportedRootClassType;
            LOG.logp(Level.WARNING, CLASS, METHOD, m);
        }
        return supportedClassTypes;
    }
}
