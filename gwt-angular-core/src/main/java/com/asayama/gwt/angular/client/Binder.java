package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.JSClosure;

public interface Binder<T> {
	T create(Class<? extends T> klass);
    JSClosure binder(Class<? extends T> klass, T object);
}
