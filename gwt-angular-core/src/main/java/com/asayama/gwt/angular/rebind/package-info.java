/**
 * Provides the code generator implementations used in this project. This 
 * package uses Apache Velocity as the template engine (http://velocity.apache.org/).
 * <p>
 * To use this code generator, you need to include the velocity in your 
 * classpath at compile time. This library is no needed at runtime once the
 * code has been compiled into JavaScript files. The library is needed at 
 * runtime for hosted mode.
 * </p>
 * <pre>{@code
<dependency>
  <groupId>org.apache.velocity</groupId>
  <artifactId>velocity</artifactId>
  <version>1.7</version>
</dependency>
 * }</pre>
 * 
 * @see com.asayama.gwt.angular.client.annotations.Bind
 */
package com.asayama.gwt.angular.rebind;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.asayama.gwt.angular.client.Injectable;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.rebind.util.ClassTypeFields;
import com.asayama.gwt.angular.rebind.util.Field;
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
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;

class VelocityGenerator {

	static final VelocityEngine VELOCITY_ENGINE = new VelocityEngine();
	static final String ENCODING = "UTF-8";
	
	static {
		VELOCITY_ENGINE.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		VELOCITY_ENGINE.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		VELOCITY_ENGINE.init();
	}
	
	final VelocityContext velocityContext;
	final String filename;
	
	VelocityGenerator(String filename) {
		velocityContext = new VelocityContext();
		this.filename = filename;
	}
	
	VelocityGenerator put(String key, Object value) {
		velocityContext.put(key, value);
		return this;
	}

	void merge(Writer writer) {
		Template template = VELOCITY_ENGINE.getTemplate(filename, ENCODING);
		template.merge(velocityContext, writer);

	    if (System.getProperty("velocity.print") != null) {
	        try {
    			Writer w = new OutputStreamWriter(System.out);
    			template.merge(velocityContext, w);
    			w.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

}

abstract class AbstractGenerator extends Generator {

    private static final String CLASS = AbstractGenerator.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

    abstract String getFilename();

    protected JClassType getClassType(GeneratorContext context, String qualifiedClassName) throws RebindException {

        final String METHOD = "getClassType(GeneratorContext, String)";
        
        JClassType classType = null;
        try {
            TypeOracle typeOracle = context.getTypeOracle();
            classType = typeOracle.getType(qualifiedClassName);
        } catch (NotFoundException e) {
            String m = qualifiedClassName + " was not found";
            LOG.logp(Level.SEVERE, CLASS, METHOD, m);
            throw new RebindException(m);
        }
        return classType;
    }
    
    protected String generate(TreeLogger logger, GeneratorContext context, VelocityGenerator velocity, String packageName, String className) {
        PrintWriter wrier = context.tryCreate(logger, packageName, "__" + className);
        if (wrier != null) {
            // The type has not yet been generated. Generate.
            velocity.merge(wrier);
            context.commit(logger, wrier);
        }
        return packageName + ".__" + className;
    }
}

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
