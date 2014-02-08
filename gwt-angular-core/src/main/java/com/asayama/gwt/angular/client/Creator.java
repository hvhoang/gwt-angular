package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.JSArray;

public interface Creator<T> {
	T create(Class<? extends T> klass);
//	JSObject constructor(Invoker invoker);
	JSArray<Object> dependencies(Class<? extends T> klass);
}
