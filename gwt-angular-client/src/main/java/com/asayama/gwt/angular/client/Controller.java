package com.asayama.gwt.angular.client;


public interface Controller {
	
	void onControllerLoad();
	
	public static interface Constructor {
		<T extends Controller> JS _getConstructor(T me);
		<T extends Module> void _injectServices(T module);
	}
}
