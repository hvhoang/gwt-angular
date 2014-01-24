package com.asayama.gwt.angular.rebind.util;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.core.ext.typeinfo.JClassType;

public class JClassTypeUtils {

	public static boolean supports(JClassType classType, Class<?> supportType) {
		String testTypeName = classType.getQualifiedSourceName();
		String supportTypeName = supportType.getName();
		if (testTypeName.equals(supportTypeName)) {
			return true;
		}
		Set<? extends JClassType> interfaces = remove(classType.getFlattenedSupertypeHierarchy(), classType);
		if (interfaces == null) {
			return false;
		}
		for (JClassType implementedInterface : interfaces) {
			if (supports(implementedInterface, supportType)) {
				return true;
			}
		}
		return false;
	}
	
	public static Set<? extends JClassType> remove(Set<? extends JClassType> set, JClassType remove) {
		HashSet<JClassType> result = new HashSet<JClassType>();
		if (set == null) {
			return result;
		}
		for (JClassType type : set) {
			if (type.equals(remove)) {
				continue;
			}
			result.add(type);
		}
		return result;
	}
}
