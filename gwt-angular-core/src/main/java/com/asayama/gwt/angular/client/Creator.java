package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.JsArray;

public interface Creator<T> {
	T create(Class<? extends T> klass);
	JsArray<JSObject> dependencies(Class<? extends T> klass);
	JSObject constructor(Class<? extends T> klass, Invoker invoker);
}
