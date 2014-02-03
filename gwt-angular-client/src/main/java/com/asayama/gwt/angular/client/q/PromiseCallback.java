package com.asayama.gwt.angular.client.q;

import com.google.gwt.core.client.JsArray;


public abstract class PromiseCallback {

	public abstract void onSuccess(JsArray<?> object);
	
	public abstract void onError(JsArray<?> object);
	
	public void onSignal(JsArray<?> object) {
		//noop by default
	}
}
