package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.GWT;

public class Deferred<T extends JSObject> implements Wrapper {

	public void singal(T value) {
		GWT.log("Deferred.singal: " + (value == null ? null : value.getClass().getName()));
		delegate.signal(value);
	}
	
	public void resolve(T value) {
		GWT.log("Deferred.resolve: " + (value == null ? null : value.getClass().getName()));
		delegate.resolve(value);
	}
	
	public void reject(T value) {
		GWT.log("Defered.reject: " + (value == null ? null : value.getClass().getName()));
		delegate.reject(value);
	}
	
	public Promise<T> promise() {
		GWT.log("Defered.promise");
		return delegate.promise();
	}
	
	// Wrapper Methods
	
	DeferredJSO<T> delegate = null;

	@Override
	public void wrap(JSObject delegate) {
		this.delegate = delegate.cast();
	}

}
class DeferredJSO<T extends JSObject> extends JSObject {

	protected DeferredJSO() {
	}

	final native void signal(T value) /*-{
		this.notify(value);
	}-*/;
	final native void resolve(T value) /*-{
		this.resolve(value);
	}-*/;
	final native void reject(T value) /*-{
		this.reject(value);
	}-*/;
	final native Promise<T>/*JSO*/ promise() /*-{
		return this.promise;
	}-*/;
}