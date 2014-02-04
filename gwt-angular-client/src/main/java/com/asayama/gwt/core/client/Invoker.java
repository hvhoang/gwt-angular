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
		return (JavaScriptObject) delegate.function();
	}
	
	public JavaScriptObject invoke(JsArray<?> jsarray) {
		Object[] args = null;
		if (jsarray != null) {
			args = new Object[jsarray.length()];
			for (int i = 0; i < jsarray.length(); i++) {
				JavaScriptObject jso = jsarray.get(i);
				args[i] = jso;
			}
		}
		return (JavaScriptObject) delegate.function(args);
	}

}
