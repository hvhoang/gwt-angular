package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.$;


public interface Service {

	static interface Constructor {
		<T extends Service> $ _getConstructor(T me);
	}
}
