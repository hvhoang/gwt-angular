package com.asayama.gwt.core.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Invoker {
	
	final Function<?> delegate;
	
	public <R> Invoker(Function<R> delegate) {
		try {
			this.delegate = delegate;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException("Incompatible callback type specified for invoker.");
		}
	}
	
	public <R extends JavaScriptObject> Invoker(Closure delegate) {
		try {
			this.delegate = delegate;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException("Incompatible callback type specified for invoker.");
		}
	}
	
	public JavaScriptObject invoke() {
		return (JavaScriptObject) delegate.function();
	}
	
	public JavaScriptObject invoke(JSArray<?> jsarray) {
		Object[] args = null;
		if (jsarray != null) {
			args = new Object[jsarray.size()];
			for (int i = 0; i < jsarray.size(); i++) {
				Object object = jsarray.get(i);
				args[i] = object;
			}
		}
		return (JavaScriptObject) delegate.function(args);
	}

}
