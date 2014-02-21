package com.asayama.gwt.rebind;

import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JParameter;

public class JMethodUtils {

	public static boolean returnsVoid(JMethod method) {
		return JTypeUtils.isVoid(method.getReturnType());
	}
	
	public static String getArgs(JMethod method) {
		StringBuilder sb = new StringBuilder();
		JParameter[] params = method.getParameters();
		for (int i = 0; i < params.length; i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(params[i].getName());
		}
		return sb.toString();
	}

}
