package com.asayama.gwt.angular.client;


public interface Service {

	static interface Constructor {
		<R extends JS, T extends Service> R _getConstructor(T me);
	}
}
