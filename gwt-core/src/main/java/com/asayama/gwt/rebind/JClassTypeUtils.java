package com.asayama.gwt.rebind;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JType;

public class JClassTypeUtils {

	public static boolean supports(JType type, Class<?> supportType) {
		JClassType classType = type.isClassOrInterface();
		if (classType == null) {
			return false;
		}
		return supports(classType, supportType);
	}

	public static boolean supports(JClassType classType, Class<?> supportType) {
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