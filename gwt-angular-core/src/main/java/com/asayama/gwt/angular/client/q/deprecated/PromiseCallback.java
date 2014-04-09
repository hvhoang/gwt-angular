package com.asayama.gwt.angular.client.q.deprecated;

@Deprecated
public abstract class PromiseCallback {

	public abstract void success(Object... args);
	
	public abstract void error(Object... args);
	
	public void notify(Object... args) {
		//noop by default
	}
}
