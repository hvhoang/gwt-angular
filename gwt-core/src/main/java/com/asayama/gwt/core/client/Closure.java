package com.asayama.gwt.core.client;

public abstract class Closure implements Function<Void> {

	public abstract void exec(Object... args);
	
	@Override
	public final Void call(Object... args) {
		exec(args);
		return null;
	}
}
