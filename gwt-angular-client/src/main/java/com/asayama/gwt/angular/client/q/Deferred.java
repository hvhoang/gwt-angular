package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.core.client.JSObject;

public class Deferred {

	DeferredJSO delegate = null;

	public void singal(Object value) {
		delegate.signal(value);
	}
	
	public void resolve(Object value) {
		delegate.resolve(value);
	}
	
	public void reject(Object value) {
		delegate.reject(value);
	}
	
	public Promise promise() {
		return delegate.promise();
	}
	
}
class DeferredJSO extends JSObject {

	protected DeferredJSO() {
	}

	final native void signal(Object value) /*-{
		this.notify(value);
	}-*/;
	
	final native void resolve(Object value) /*-{
		this.resolve(value);
	}-*/;
	
	final native void reject(Object value) /*-{
		this.reject(value);
	}-*/;
	
	final native Promise promise() /*-{
		return this.promise;
	}-*/;

}
