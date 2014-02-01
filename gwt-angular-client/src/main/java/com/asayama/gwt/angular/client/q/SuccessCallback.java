package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.core.client.JSObject;

public abstract class SuccessCallback<T extends JSObject> extends PromiseCallback<T> {
	
	@Override
	public void onError(T object) {
		// noop by default
	}

}
