package com.asayama.gwt.core.client;

public class Invoker {
	
	final Function<JSObject,JSObject> delegate;
	
	@SuppressWarnings("unchecked")
	public <R extends JSObject, T extends JSObject> Invoker(Function<R,T> delegate) {
		try {
			this.delegate = (Function<JSObject,JSObject>) delegate;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException("Incompatible callback type specified for invoker.");
		}
	}
	
	public JSObject invoke() {
		return delegate.function(null);
	}
	
	public JSObject invoke(JSObject jso) {
		return delegate.function(jso);
	}
}
