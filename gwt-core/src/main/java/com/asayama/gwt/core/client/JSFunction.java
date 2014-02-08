package com.asayama.gwt.core.client;

import com.google.gwt.core.client.JavaScriptObject;

public class JSFunction<R> extends JavaScriptObject {
	
	public static <R> JSFunction<R> create(Function<R> function) {
		return _create(new Invoker(function));
	}
	
	static native <R> JSFunction<R> _create(Invoker invoker) /*-{
		return function () {
			return invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/JSArray;)(arguments);
		};
	}-*/;

	protected JSFunction() {
	}

}
