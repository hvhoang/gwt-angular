package com.asayama.gwt.jsni.client;

import com.google.gwt.core.client.JavaScriptObject;

public class JSFunction<R> extends JavaScriptObject {
	
	public static <R> JSFunction<R> create(Function<R> function) {
		return _create(new Invoker(function));
	}
	
	static native <R> JSFunction<R> _create(Invoker invoker) /*-{
		return function () {
			return invoker.@com.asayama.gwt.jsni.client.Invoker::invoke(Lcom/asayama/gwt/jsni/client/JSArray;)(arguments);
		};
	}-*/;

	protected JSFunction() {
	}

	public final R apply(Object... args) {
	    @SuppressWarnings("unchecked")
        JSArray<Object> jsarray = (JSArray<Object>) JavaScriptObject.createArray();
	    if (args != null) {
	        for (Object arg : args) {
	            jsarray.add(arg);
	        }
	    }
	    return _apply(jsarray);
	}

	protected final native R _apply(JSArray<Object> jsarray) /*-{
	    return this.apply(null, jsarray);
	}-*/;

}
