package com.asayama.gwt.angular.client.q.deprecated;

@Deprecated
public abstract class SuccessCallback extends PromiseCallback {

	@Override
	public void error(Object... args) {
		// noop by default
	}
}
