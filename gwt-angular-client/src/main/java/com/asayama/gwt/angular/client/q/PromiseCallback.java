package com.asayama.gwt.angular.client.q;

import com.google.gwt.core.client.JsArray;


public abstract class PromiseCallback {

	public abstract void success(JsArray<?> object);
	
	public abstract void error(JsArray<?> object);
	
	public void signal(JsArray<?> object) {
		//noop by default
	}
}
