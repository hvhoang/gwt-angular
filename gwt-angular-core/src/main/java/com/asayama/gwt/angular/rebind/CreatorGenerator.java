package com.asayama.gwt.angular.rebind;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.asayama.gwt.angular.client.Injectable;
import com.asayama.gwt.rebind.JClassTypeUtils;
import com.asayama.gwt.rebind.JMethodUtils;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.core.ext.typeinfo.TypeOracle;

public class CreatorGenerator extends AbstractGenerator {

	@Override
	String getFilename() {
		return "com/asayama/gwt/angular/rebind/CreatorGenerator.vm";
	}

	@Override
	String getSuffix() {
		return "Generated";
	}

	@Override
	public String generate(TreeLogger logger, GeneratorContext context, String qualifiedName) throws UnableToCompleteException {

		try {
			final String filename = getFilename();
			VelocityGenerator velocity = new VelocityGenerator(filename);
			velocity.put("templateFilename", filename);
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
			String packageName = classType.getPackage().getName();
			String simpleName = classType.getSimpleSourceName();
			String generatedQualifiedName = packageName + "." + simpleName + getSuffix();
			String generatedSimpleName = simpleName + getSuffix();
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
			List<JClassType> returnClassTypeList = new ArrayList<JClassType>();
			if (returnClassTypes == null || returnClassTypes.length == 0) {
				return qualifiedName;
			}
			for (JClassType returnClassType : returnClassTypes) {
				returnClassTypeList.add(returnClassType);
			}
			velocity.put("parameterClassType", parameterClassType.getQualifiedSourceName());
			velocity.put("returnClassTypes", returnClassTypeList);
						
			// Helpers
			velocity.put("JClassTypeUtils", JClassTypeUtils.class);
			velocity.put("JMethodUtils", JMethodUtils.class);
			velocity.put("Injectable", Injectable.class);
			
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
