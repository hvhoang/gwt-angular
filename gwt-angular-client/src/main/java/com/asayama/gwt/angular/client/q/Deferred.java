package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.core.client.$;
import com.google.gwt.core.client.GWT;

public class Deferred<T extends $> implements Wrapper<DeferredJSO<T>> {

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
	public DeferredJSO<T> getDelegate() {
		return this.delegate;
	}

	@Override
	public void setDelegate($ delegate) {
		this.delegate = delegate.cast();
	}

}
class DeferredJSO<T extends $> extends $ {

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