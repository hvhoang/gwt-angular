package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSObject;

public interface Creator<T> {
	T create(Class<? extends T> klass);
	JSObject construct(Class<? extends T> klass, Invoker invoker);
}
