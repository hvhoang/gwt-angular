package com.asayama.gwt.angular.rebind;

import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

class VelocityGenerator {

	static final VelocityEngine ENGINE = new VelocityEngine();
	static final String ENCODING = "UTF-8";
	
	static {
		ENGINE.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ENGINE.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ENGINE.init();
	}
	
	final VelocityContext velocityContext = new VelocityContext();
	
	VelocityGenerator() {
	}
	
	VelocityGenerator put(String key, Object value) {
		velocityContext.put(key, value);
		return this;
	}

	void generate(Writer writer, String filename) {
		try {
			Template template = ENGINE.getTemplate(filename, ENCODING);
			template.merge(velocityContext, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}