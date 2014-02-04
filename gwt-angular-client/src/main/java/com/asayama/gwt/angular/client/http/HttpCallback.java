package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.q.PromiseCallback;


public abstract class HttpCallback extends PromiseCallback {

	abstract void onSuccess(Object... args);
	abstract void onError(Object... args);
	
	public void onSignal(Object... args) {
		//noop
	}

	@Override
	public final void success(Object... args) {
		onSuccess(args);
	}
	
	@Override
	public final void error(Object... args) {
		onError(args);
	}
	
	@Override
	public final void signal(Object... args) {
		onSignal(args);
	}
	
}
