package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Function;


public interface Provider {
	
	static interface Constructor {
		<T extends Provider> $ _getConstructor(T me, Function.Proxy<$> proxy);
	}
}
