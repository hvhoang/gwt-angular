package com.asayama.gwt.angular.rebind;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.core.client.$;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JField;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.TypeOracle;

public class ControllerGenerator extends Generator {
	
	@Override
	public String generate(TreeLogger logger, GeneratorContext context, String qualifiedName) throws UnableToCompleteException {

		try {
			final String filename = "Controller.vm";
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

			// $scope initialization
			{
				List<JMethod> methodList = new ArrayList<JMethod>();
				JMethod[] methods = classType.getInheritableMethods();
				for (JMethod item : methods) {
					if (item.isPublic()) {
						methodList.add(item);
					}
				}
				velocity.put("exportMethods", methodList);
			}
			// Services
			{
				List<JField> fieldList = new ArrayList<JField>();
				List<JField> nativeList = new ArrayList<JField>();
				JField[] fields = classType.getFields();
				for (JField item : fields) {
					JClassType itemClassType = item.getType().isClassOrInterface();
					if (itemClassType != null && JClassTypeUtils.supports(itemClassType, Service.class)) {
						if (JClassTypeUtils.supports(itemClassType, $.class)) {
							nativeList.add(item);
						} else {
							fieldList.add(item);
						}
					}
				}
				velocity.put("serviceFields", fieldList);
				velocity.put("nativeServiceFields", nativeList);
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
