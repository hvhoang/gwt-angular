package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.JSClosure;

public interface Injector<T> {
	T create(Class<? extends T> klass);
    JSClosure injector(Class<? extends T> klass, T object);
}
