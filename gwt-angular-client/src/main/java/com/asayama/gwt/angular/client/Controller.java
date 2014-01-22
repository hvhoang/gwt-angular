package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.$;


public interface Controller {
	
	void onControllerLoad();
	
	public static interface Constructor {
		<T extends Controller> $ _getConstructor(T me);
		<T extends Module> void _injectServices(T module);
	}
}
