package com.asayama.gwt.angular.client.q;

import com.google.gwt.core.client.JsArray;

public abstract class ErrorCallback extends PromiseCallback {

	@Override
	public void success(JsArray<?> object) {
		// noop by default
	}
	
}
