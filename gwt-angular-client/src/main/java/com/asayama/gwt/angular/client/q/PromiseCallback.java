package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.core.client.$;

public abstract class PromiseCallback<T extends $> {

	public abstract void onSuccess(T object);
	
	public abstract void onError(T object);
	
	public void onSignal(T object) {
		//noop by default
	}
}
