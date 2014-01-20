package com.asayama.gwt.angular.client;

import com.google.gwt.core.client.JavaScriptObject;

public interface Service {

	static interface Constructor {
		<T extends Service, R extends JavaScriptObject> R _get(T me);
	}
}
