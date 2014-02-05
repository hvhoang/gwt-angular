package com.asayama.gwt.angular.rebind;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.core.ext.typeinfo.JClassType;

public class JClassTypeUtils {

	static boolean supports(JClassType classType, Class<?> supportType) {
		String testTypeName = classType.getQualifiedSourceName();
		String supportTypeName = supportType.getName();
		if (testTypeName.equals(supportTypeName)) {
			return true;
		}
		Set<? extends JClassType> interfaces = new HashSet<JClassType>(
				classType.getFlattenedSupertypeHierarchy());
		interfaces.remove(classType);
		for (JClassType implementedInterface : interfaces) {
			if (supports(implementedInterface, supportType)) {
				return true;
			}
		}
		return false;
	}
}
