package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.q.PromiseCallback;
import com.google.gwt.core.client.JsArray;


public abstract class HttpCallback extends PromiseCallback {

	abstract void onSuccess(JsArray<?> object);
	abstract void onError(JsArray<?> object);
	
	public void onSignal(JsArray<?> object) {
		//noop
	}
	
	@Override
	public final void success(JsArray<?> object) {
		onSuccess(object);
	}
	
	@Override
	public final void error(JsArray<?> object) {
		onError(object);
	}
	
	@Override
	public void signal(JsArray<?> object) {
		onSignal(object);
	}
	
}
