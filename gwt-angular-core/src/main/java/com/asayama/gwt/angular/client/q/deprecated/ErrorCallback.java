package com.asayama.gwt.angular.client.q.deprecated;

@Deprecated
public abstract class ErrorCallback extends PromiseCallback {

	@Override
	public void success(Object... args) {
		// noop by default
	}

}
