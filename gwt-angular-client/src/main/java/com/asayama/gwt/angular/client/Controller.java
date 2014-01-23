package com.asayama.gwt.angular.client;



public interface Controller extends Injectable {
	
	void onControllerLoad();
	void onInjection(Injectable object);
	
	public static interface Constructor extends com.asayama.gwt.angular.client.Constructor {
		<T extends Module> void _injectServices(T module);
	}
}
