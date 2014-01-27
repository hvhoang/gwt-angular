package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.core.client.$;

public abstract class ErrorCallback<T extends $> extends PromiseCallback<T> {

	@Override
	public void onSuccess(T object) {
		// noop by default
	}
	
}
