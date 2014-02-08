package com.asayama.gwt.angular.client.q;



public abstract class PromiseCallback {

	public abstract void success(Object... args);
	
	public abstract void error(Object... args);
	
	public void signal(Object... args) {
		//noop by default
	}
}
