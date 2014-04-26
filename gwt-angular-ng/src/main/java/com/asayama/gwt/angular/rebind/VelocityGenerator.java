package com.asayama.gwt.angular.rebind;

import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;


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
