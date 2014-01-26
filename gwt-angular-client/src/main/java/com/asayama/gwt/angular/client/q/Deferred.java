package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.core.client.$;

public class Deferred implements Wrapper<DeferredJSO> {

	public void singal(String value) {
		delegate.signal(value);
	}
	
	public void resolve(String value) {
		delegate.resolve(value);
	}
	
	public void reject(String value) {
		delegate.reject(value);
	}
	
	public Promise promise() {
		Promise promise = new Promise();
		promise.setDelegate(delegate.promise());
		return promise;
	}
	
	// Wrapper Methods
	
	DeferredJSO delegate = null;
	
	@Override
	public DeferredJSO getDelegate() {
		return this.delegate;
	}

	@Override
	public void setDelegate(DeferredJSO delegate) {
		this.delegate = delegate;
	}

}
class DeferredJSO extends $ {

	protected DeferredJSO() {
	}

	final native void signal(String value) /*-{
		this.notify(value);
	}-*/;
	final native void resolve(String value) /*-{
		this.resolve(value);
	}-*/;
	final native void reject(String value) /*-{
		this.reject(value);
	}-*/;
	final native PromiseJSO promise() /*-{
		return this.promise;
	}-*/;
}