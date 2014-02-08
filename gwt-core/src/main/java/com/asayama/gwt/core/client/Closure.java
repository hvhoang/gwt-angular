package com.asayama.gwt.core.client;



public abstract class Closure implements Function<Void> {

	public abstract void closure(Object... args);
	
	@Override
	public Void function(Object... args) {
		closure(args);
		return null;
	}

}
