package com.asayama.gwt.core.client.util;

public class Objects {

	public static <T> T coalesce(T... objects) {
		if (objects == null) {
			return null;
		}
		for (T object : objects) {
			if (object != null) {
				return object;
			}
		}
		return null;
	}
	
}
