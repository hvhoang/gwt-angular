package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.JSObject;

public interface Wrapper<T extends JSObject> {
	T getDelegate();
	void setDelegate(JSObject delegate);
}
