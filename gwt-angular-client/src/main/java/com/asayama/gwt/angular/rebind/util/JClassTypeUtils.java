package com.asayama.gwt.angular.rebind.util;

import com.google.gwt.core.ext.typeinfo.JClassType;

public class JClassTypeUtils {

	public static boolean supports(JClassType classType, Class<?> supportType) {
		String testTypeName = classType.getQualifiedSourceName();
		String supportTypeName = supportType.getName();
		if (testTypeName.equals(supportTypeName)) {
			return true;
		}
		JClassType[] implementedInterfaces = classType.getImplementedInterfaces();
		if (implementedInterfaces == null) {
			return false;
		}
		for (JClassType implementedInterface : implementedInterfaces) {
			if (supports(implementedInterface, supportType)) {
				return true;
			}
		}
		return false;
	}
}
