package com.asayama.gwt.angular.rebind;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.Provider;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.TypeOracle;

public class ModuleGenerator extends Generator {
	
	@Override
	public String generate(TreeLogger logger, GeneratorContext context, String qualifiedName) throws UnableToCompleteException {

		try {
			final String filename = "Module.vm";
			VelocityGenerator velocity = new VelocityGenerator(filename);
			velocity.put("logger", logger);
			velocity.put("context", context);
			velocity.put("qualifiedName", qualifiedName);
			
			TypeOracle typeOracle = context.getTypeOracle();
			JClassType classType = typeOracle.getType(qualifiedName);
			velocity.put("classType", classType);
			
			if (classType.isFinal()) {
				throw new UnsupportedOperationException(qualifiedName + " should not be declared final");
			}
			
			// Define basic characteristics of the generated type.
			final String suffix = "Generated";
			String packageName = classType.getPackage().getName();
			String simpleName = classType.getSimpleSourceName();
			String generatedQualifiedName = qualifiedName + suffix;
			String generatedSimpleName = simpleName + suffix;
			velocity.put("packageName", packageName);
			velocity.put("simpleName", simpleName);
			velocity.put("generatedQualifiedName", generatedQualifiedName);
			velocity.put("generatedSimpleName", generatedSimpleName);
			
			// Identify the providers to inject
			{
				List<JField> list = new ArrayList<JField>();
				JField[] fields = classType.getFields();
				for (JField field : fields) {
					JClassType fieldClassType = field.getType().isClassOrInterface();
					if (fieldClassType != null && JClassTypeUtils.supports(fieldClassType, Provider.class)) {
						list.add(field);
					}
				}
				velocity.put("providerFields", list);
			}

			// Identify the services to inject
			{
				List<JField> list = new ArrayList<JField>();
				JField[] fields = classType.getFields();
				for (JField field : fields) {
					JClassType fieldClassType = field.getType().isClassOrInterface();
					if (fieldClassType != null
							&& JClassTypeUtils.supports(fieldClassType, Service.class)
							&& !JClassTypeUtils.supports(fieldClassType, JSObject.class)) {
						list.add(field);
					}
				}
				velocity.put("serviceFields", list);
			}

			// Identify the native services to inject
			{
				List<JField> list = new ArrayList<JField>();
				JField[] fields = classType.getFields();
				for (JField field : fields) {
					JClassType fieldClassType = field.getType().isClassOrInterface();
					if (fieldClassType != null
							&& JClassTypeUtils.supports(fieldClassType, Service.class)
							&& JClassTypeUtils.supports(fieldClassType, JSObject.class)) {
						list.add(field);
					}
				}
				velocity.put("nativeServiceFields", list);
			}

			// Identify the controllers to inject
			{
				List<JField> list = new ArrayList<JField>();
				JField[] fields = classType.getFields();
				for (JField field : fields) {
					JClassType fieldClassType = field.getType().isClassOrInterface();
					if (fieldClassType != null && JClassTypeUtils.supports(fieldClassType, Controller.class)) {
						list.add(field);
					}
				}
				velocity.put("controllerFields", list);
			}
			
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
