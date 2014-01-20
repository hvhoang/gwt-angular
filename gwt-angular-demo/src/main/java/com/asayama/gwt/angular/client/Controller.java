package com.asayama.gwt.angular.client;

import com.google.gwt.core.client.JavaScriptObject;

public interface Controller {
	
	void onControllerLoad();
	
	public static interface Constructor {
		<T extends Controller, R extends JavaScriptObject> R _get(T me);
		<T extends Module> void _injectServices(T module);
	}
}
