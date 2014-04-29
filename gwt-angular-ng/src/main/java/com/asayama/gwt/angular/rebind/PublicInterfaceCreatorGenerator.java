package com.asayama.gwt.angular.rebind;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.ext.typeinfo.JClassType;

public class PublicInterfaceCreatorGenerator extends DefaultInstantiableCreatorGenerator {

    private static final String CLASS = PublicInterfaceCreatorGenerator.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

    protected List<JClassType> getSupportedClassTypes(JClassType supportedRootClassType) {
        
        final String METHOD = "getSupportedSubClassTypes(JClassType)";
        
        JClassType[] supportedSubClassTypes = supportedRootClassType.getSubtypes();
        List<JClassType> supportedClassTypes = new ArrayList<JClassType>();
        if (supportedSubClassTypes != null) {
            for (JClassType returnClassType : supportedSubClassTypes) {
            	if (returnClassType.isAbstract() && returnClassType.isPublic()) {
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
