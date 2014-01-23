package com.asayama.gwt.core.client;

public class Invoker {
	
	final Function<$> delegate;
	
	@SuppressWarnings("unchecked")
	public <T extends $> Invoker(Function<T> delegate) {
		try {
			this.delegate = (Function<$>) delegate;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException("Incompatible callback type specified for invoker.");
		}
	}
	
	public $ invoke() {
		return delegate.function(null);
	}
	
	public $ invoke($ jso) {
		return delegate.function(jso);
	}
}
