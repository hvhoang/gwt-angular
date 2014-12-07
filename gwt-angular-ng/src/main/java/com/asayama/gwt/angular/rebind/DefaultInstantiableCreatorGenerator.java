package com.asayama.gwt.angular.rebind;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;


public class DefaultInstantiableCreatorGenerator extends AbstractFactoryGenerator {

    private static final String CLASS = DefaultInstantiableCreatorGenerator.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

	@Override
	String getFilename() {
		return "com/asayama/gwt/angular/rebind/CreatorFactory.vm";
	}
	
	@Override
	protected String generate(TreeLogger logger, GeneratorContext context, VelocityGenerator velocity, String packageName, String className) {
        JClassType classType = getClassType(context, packageName + "." + className);
		String creatorReturnType = getCreatorReturnType(classType);
		velocity.put("creatorReturnType", creatorReturnType);
		return super.generate(logger, context, velocity, packageName, className);
	}

    protected String getCreatorReturnType(JClassType classType) {
    	final String METHOD = "getCreatorReturnType(JClassType)";
        String creatorReturnType = null;
        JMethod[] methods = classType.getMethods();
        for (JMethod method : methods) {
	        creatorReturnType = method.getReturnType().getQualifiedSourceName();
	        if (creatorReturnType != null) {
	        	break;//we expect to see only one creator method
	        }
        }
        if (creatorReturnType == null) {
        	LOG.logp(Level.WARNING, CLASS, METHOD, "Unable to identify creatorReturnType.");
        }
        return creatorReturnType;
    }

}
