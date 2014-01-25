package com.asayama.gwt.core.client;

public abstract class Closure<T extends $> implements Function<T> {

	public abstract void closure(T jso);
	
	@Override
	public final $ function(T jso) {
		closure(jso);
		return jso;
	}
}
