package com.asayama.gwt.util.client;

public class Objects {

	@SafeVarargs
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
