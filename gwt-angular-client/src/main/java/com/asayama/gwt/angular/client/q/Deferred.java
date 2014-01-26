package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.core.client.$;

public class Deferred<T extends $> implements Wrapper<DeferredJSO<T>> {

	public void singal(T value) {
		delegate.signal(value);
	}
	
	public void resolve(T value) {
		delegate.resolve(value);
	}
	
	public void reject(T value) {
		delegate.reject(value);
	}
	
	public Promise<T> promise() {
		Promise<T> promise = new Promise<T>();
		promise.setDelegate(delegate.promise());
		return promise;
	}
	
	// Wrapper Methods
	
	DeferredJSO<T> delegate = null;
	
	@Override
	public DeferredJSO<T> getDelegate() {
		return this.delegate;
	}

	@Override
	public void setDelegate(DeferredJSO<T> delegate) {
		this.delegate = delegate;
	}

}
class DeferredJSO<T> extends $ {

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
	final native PromiseJSO promise() /*-{
		return this.promise;
	}-*/;
}