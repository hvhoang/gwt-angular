package com.asayama.gwt.core.client;


public class Invoker<T extends $> implements Function<T> {
	
	final Function<T> delegate;
	
	public Invoker(Function<T> delegate) {
		this.delegate = delegate;
	}
	
	public $ invoke(T jso) {
		return delegate.invoke(jso);
	}
}
