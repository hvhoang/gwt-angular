package com.asayama.gwt.angular.rebind;

import java.io.PrintWriter;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameterizedType;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.TypeOracle;

public class CreatorGenerator extends Generator {

	@Override
	public String generate(TreeLogger logger, GeneratorContext context, String qualifiedName) throws UnableToCompleteException {

		try {
			final String filename = "Creator.vm";
			VelocityGenerator velocity = new VelocityGenerator(filename);
			velocity.put("logger", logger);
			velocity.put("context", context);
			velocity.put("qualifiedName", qualifiedName);
			
			TypeOracle typeOracle = context.getTypeOracle();
			JClassType classType = typeOracle.getType(qualifiedName);
			velocity.put("classType", classType);

			if (classType.isInterface() == null) {
				return qualifiedName;
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
			
			// Find the public create(Class<T>) method's return type
			JClassType parameterClassType = null;
			JMethod[] methods = classType.getInheritableMethods();
			for (JMethod method : methods) {
				if (method.getName().equals("create")) {
					JType returnType = method.getReturnType();
					parameterClassType = returnType.isClassOrInterface();
					if (parameterClassType != null) {
						break;
					}
				}
			}
			
			if (parameterClassType == null) {
				return qualifiedName;
			}
			
			// Find all the subtypes of this return type
			JClassType[] returnClassTypes = parameterClassType.getSubtypes();
			if (returnClassTypes == null || returnClassTypes.length == 0) {
				return qualifiedName;
			}
			velocity.put("parameterClassType", parameterClassType.getQualifiedSourceName());
			velocity.put("returnClassTypes", returnClassTypes);
			
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
