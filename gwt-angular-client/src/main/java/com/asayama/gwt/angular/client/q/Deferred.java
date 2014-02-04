package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.JavaScriptObject;

public class Deferred {

	DeferredJSO delegate = null;

	public void singal(JavaScriptObject value) {
		delegate.signal(value);
	}
	
	public void resolve(JavaScriptObject value) {
		delegate.resolve(value);
	}
	
	public void reject(JavaScriptObject value) {
		delegate.reject(value);
	}
	
	public Promise promise() {
		return delegate.promise();
	}
	
}
class DeferredJSO extends JSObject {

	protected DeferredJSO() {
	}

	final native void signal(JavaScriptObject value) /*-{
		this.notify(value);
	}-*/;
	
	final native void resolve(JavaScriptObject value) /*-{
		this.resolve(value);
	}-*/;
	
	final native void reject(JavaScriptObject value) /*-{
		this.reject(value);
	}-*/;
	
	final native Promise promise() /*-{
		return this.promise;
	}-*/;

}
