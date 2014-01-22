package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.$;


public interface Service {

	static interface Constructor {
		<R extends $, T extends Service> R _getConstructor(T me);
	}
}
