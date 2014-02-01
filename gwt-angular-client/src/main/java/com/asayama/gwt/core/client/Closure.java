package com.asayama.gwt.core.client;

public abstract class Closure<T extends JSObject> implements Function<Void, T> {

	public abstract void closure(T jso);
	
	@Override
	public final Void function(T jso) {
		closure(jso);
		return Void.INSTANCE;
	}
}
class Void extends JSObject {
	public static final Void INSTANCE = Void.create();
	protected Void() {
	}
}