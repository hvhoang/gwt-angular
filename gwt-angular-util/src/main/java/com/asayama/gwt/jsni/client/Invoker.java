package com.asayama.gwt.jsni.client;


public class Invoker {
	
	final Function<?> delegate;
	
	public <R> Invoker(Function<R> delegate) {
		try {
			this.delegate = delegate;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException("Incompatible callback type specified for invoker.");
		}
	}
	
	public <R> Invoker(Closure delegate) {
		try {
			this.delegate = delegate;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException("Incompatible callback type specified for invoker.");
		}
	}
	
	public Object invoke() {
		return (Object) delegate.call();
	}
	
	public Object invoke(JSArray<?> jsarray) {
		Object[] args = null;
		if (jsarray != null) {
			args = new Object[jsarray.size()];
			for (int i = 0; i < jsarray.size(); i++) {
				Object object = jsarray.get(i);
				args[i] = object;
			}
		}
		return (Object) delegate.call(args);
	}

}
