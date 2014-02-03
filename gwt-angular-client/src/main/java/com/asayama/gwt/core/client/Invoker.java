package com.asayama.gwt.core.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Invoker {
	
	final Function<?> delegate;
	
	public <R extends JavaScriptObject> Invoker(Function<R> delegate) {
		try {
			this.delegate = delegate;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException("Incompatible callback type specified for invoker.");
		}
	}
	
	public JavaScriptObject invoke() {
		return delegate.function(null);
	}
	
	public JavaScriptObject invoke(JsArray<?> jso) {
		return delegate.function(jso);
	}

}
