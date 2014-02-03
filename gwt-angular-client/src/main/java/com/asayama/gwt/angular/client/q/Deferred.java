package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.JsArray;

public class Deferred implements Wrapper {

	public void singal(JsArray<?> value) {
		delegate.signal(value);
	}
	
	public void resolve(JsArray<?> value) {
		delegate.resolve(value);
	}
	
	public void reject(JsArray<?> value) {
		delegate.reject(value);
	}
	
	public Promise promise() {
		return delegate.promise();
	}
	
	// Wrapper Methods
	
	DeferredJSO delegate = null;

	@Override
	public void wrap(JsArray<?> jsarray) {
		if (jsarray != null && jsarray.length() > 0) {
			this.delegate = jsarray.get(0).cast();
		}
	}

}
class DeferredJSO extends JSObject {

	protected DeferredJSO() {
	}

	final native void signal(JsArray<?> value) /*-{
		this.notify(value);
	}-*/;
	final native void resolve(JsArray<?> value) /*-{
		this.resolve(value);
	}-*/;
	final native void reject(JsArray<?> value) /*-{
		this.reject(value);
	}-*/;
	final native Promise promise() /*-{
		return this.promise;
	}-*/;

}
