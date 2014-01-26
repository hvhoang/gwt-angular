package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Invoker;

public class Promise implements Wrapper<PromiseJSO> {

	public Promise then(final PromiseCallback callback) {
		delegate.then(new Invoker(new Closure<$>() {
			@Override
			public void closure($ jso) {
				callback.onSuccess();
			}
		}), new Invoker(new Closure<$>() {
			@Override
			public void closure($ jso) {
				callback.onError();
			}
		}), new Invoker(new Closure<$>() {
			@Override
			public void closure($ jso) {
				callback.onSignal();
			}
		}));
		return this;
	}
	
	public Promise error(Closure<$> closure) {
		delegate.error(new Invoker(closure));
		return this;
	}
	
	public Promise end(Closure<$> closure) {
		delegate.end(new Invoker(closure));
		return this;
	}
	
	// Wrapper Interfaces
	
	PromiseJSO delegate = null;
	
	@Override
	public PromiseJSO getDelegate() {
		return this.delegate;
	}

	@Override
	public void setDelegate(PromiseJSO delegate) {
		this.delegate = delegate;
	}

}
class PromiseJSO extends $ {

	protected PromiseJSO() {
	}

	final native void then(Invoker successCallback, Invoker errorCallback, Invoker signalCallback) /*-{
		this.then(successCallback, errorCallback, signalCallback);
	}-*/;
	
	final native void error(Invoker errorCallback) /*-{
		this.error(errorCallback);
	}-*/;

	final native void end(Invoker endCallback) /*-{
		this.finally(endCallback);
	}-*/;
}
