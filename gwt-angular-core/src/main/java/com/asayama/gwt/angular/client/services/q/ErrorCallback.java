package com.asayama.gwt.angular.client.services.q;


public abstract class ErrorCallback extends PromiseCallback {

	@Override
	public void success(Object... args) {
		// noop by default
	}

}
