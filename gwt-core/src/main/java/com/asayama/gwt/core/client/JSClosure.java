package com.asayama.gwt.core.client;

public class JSClosure extends JSFunction<Void> {

	public static JSClosure create(Closure closure) {
		return _create(new Invoker(closure)).<JSClosure>cast();
	}
	
	protected JSClosure() {
	}

}
