package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.core.client.JSObject;

public abstract class ErrorCallback<T extends JSObject> extends PromiseCallback<T> {

	@Override
	public void onSuccess(T object) {
		// noop by default
	}
	
}
