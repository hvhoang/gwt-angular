package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSObject;

public class Deferred {

	DeferredJSO delegate = null;

	public void notify(Object... values) {
		delegate.notify(JSArray.create(values));
	}
	
	public void resolve(Object... values) {
		delegate.resolve(JSArray.create(values));
	}
	
	public void reject(Object... values) {
		delegate.reject(JSArray.create(values));
	}
	
	public Promise promise() {
		return delegate.promise();
	}
	
}
class DeferredJSO extends JSObject {

	protected DeferredJSO() {
	}

	final native void notify(JSArray<Object> value) /*-{
		this.notify(value);
	}-*/;
	
	final native void resolve(JSArray<Object> value) /*-{
		this.resolve(value);
	}-*/;
	
	final native void reject(JSArray<Object> value) /*-{
		this.reject(value);
	}-*/;
	
	final native Promise promise() /*-{
		return this.promise;
	}-*/;

}
