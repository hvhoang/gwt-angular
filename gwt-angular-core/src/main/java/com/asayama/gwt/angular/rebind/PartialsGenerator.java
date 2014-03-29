package com.asayama.gwt.angular.rebind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.Partial;
import com.asayama.gwt.angular.client.Partials.Resource;
import com.asayama.gwt.rebind.JClassTypeUtils;
import com.asayama.gwt.rebind.JMethodUtils;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameter;
import com.google.gwt.core.ext.typeinfo.JType;


public class PartialsGenerator extends AbstractGenerator {

    private static final String CLASS = PartialsGenerator.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

    @Override
    String getFilename() {
        return "com/asayama/gwt/angular/rebind/Partials.vm";
    }

    @Override
    public String generate(TreeLogger logger, GeneratorContext context, String qualifiedClassName) throws UnableToCompleteException {
        
        final String METHOD = "generate(TreeLogger, GeneratorContext, String)";
        JClassType classType = getClassType(context, qualifiedClassName);
        String packageName = classType.getPackage().getName();
        String className = classType.getSimpleSourceName();

        VelocityGenerator velocity = new VelocityGenerator(getFilename());
        velocity.put("classType", classType);
        velocity.put("packageName", packageName);
        velocity.put("className", className);
        velocity.put("JMethodUtils", JMethodUtils.class);
        
        Map<JMethod, Properties> methodProperties = new HashMap<JMethod, Properties>();
        List<JMethod> methodList = new ArrayList<JMethod>();
        JMethod[] methods = classType.getInheritableMethods();
        if (methods != null) {
            for (JMethod method : methods) {
                Properties props = new Properties();

                if (!method.isAbstract()) {
                    continue;
                }
                
                JParameter[] param = method.getParameters();
                if (param != null && param.length > 0) {
                    LOG.logp(Level.WARNING, CLASS, METHOD, method.getName() + " accepts " + param.length + " parameters. 0 was expected.");
                    continue;
                }
                
                Resource source = method.getAnnotation(Resource.class);
                if (source == null) {
                    LOG.logp(Level.WARNING, CLASS, METHOD, method.getName() + " is missing @Reource annotation");
                    continue;
                }
                props.put("source", source.value());
                
                JType returnType = method.getReturnType();
                if (!JClassTypeUtils.supports(returnType, Partial.class)) {
                    LOG.logp(Level.WARNING, CLASS, METHOD, method.getName() + " should return " + Partial.class);
                    continue;
                }

                methodList.add(method);
                methodProperties.put(method, props);
            }
        }
        velocity.put("methods", methodList);
        velocity.put("methodProperties", methodProperties);

        return generate(logger, context, velocity, packageName, className);
    }

}
