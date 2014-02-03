package com.asayama.gwt.core.client;

import com.google.gwt.core.client.JsArray;

public abstract class Closure implements Function<Void> {

	public abstract void closure(JsArray<?> jsarray);
	
	@Override
	public Void function(JsArray<?> jsarray) {
		closure(jsarray);
		return Void.INSTANCE;
	}
}
class Void extends JSObject {
	public static final Void INSTANCE = Void.create();
	protected Void() {
	}
}