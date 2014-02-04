package com.asayama.gwt.angular.client.q;

import com.google.gwt.core.client.JsArray;

public abstract class SuccessCallback extends PromiseCallback {
	
	@Override
	public void error(JsArray<?> object) {
		// noop by default
	}

}
