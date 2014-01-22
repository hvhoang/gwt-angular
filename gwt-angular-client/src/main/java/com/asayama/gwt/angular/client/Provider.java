package com.asayama.gwt.angular.client;


public interface Provider {
	
	static interface Constructor {
		<T extends Provider> JS _getConstructor(T me, Function.Proxy<JS> proxy);
	}
}
