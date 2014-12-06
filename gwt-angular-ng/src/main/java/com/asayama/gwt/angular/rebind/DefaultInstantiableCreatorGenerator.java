package com.asayama.gwt.angular.rebind;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.rebind.exceptions.RebindException;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JType;

public class DefaultInstantiableCreatorGenerator extends AbstractFactoryGenerator {

    private static final String CLASS = DefaultInstantiableCreatorGenerator.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

	@Override
	String getFilename() {
		return "com/asayama/gwt/angular/rebind/CreatorFactory.vm";
	}

	@Override
    protected JClassType getSupportedRootClassType(GeneratorContext context, JClassType classType) {
        
        final String METHOD = "getSupportedRootClassType(JClassType)";
        
        JClassType supportedRootClassType = null;
        JMethod[] methods = classType.getInheritableMethods();
        for (JMethod method : methods) {
            JType returnType = method.getReturnType();
            supportedRootClassType = returnType.isClassOrInterface();
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

}
