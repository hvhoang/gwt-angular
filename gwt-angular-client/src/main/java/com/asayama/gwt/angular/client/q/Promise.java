package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.JsArray;

/**
 * TODO T should not have to extend JSObject.
 */
public class Promise extends JSObject {

	protected Promise() {
	}
	
	public final Promise then(final PromiseCallback callback) {
		_then(new Invoker(new Closure() {
			@Override
			public void closure(JsArray<?> jsarray) {
				callback.onSuccess(jsarray);
			}
		}), new Invoker(new Closure() {
			@Override
			public void closure(JsArray<?> jsarray) {
				callback.onError(jsarray);
			}
		}), new Invoker(new Closure() {
			@Override
			public void closure(JsArray<?> jsarray) {
				callback.onSignal(jsarray);
			}
		}));
		return this;
	}
	
	public final Promise success(SuccessCallback callback) {
		then(callback);
		return this;
	}
	
	public final Promise error(ErrorCallback callback) {
		then(callback);
		return this;
	}

	final native void _then(Invoker successCallback, Invoker errorCallback, Invoker signalCallback) /*-{
		this.then(
			function (jsarray) {
				successCallback.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/google/gwt/core/client/JsArray;)(jsarray);
			}, function (jsarray) {
				errorCallback.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/google/gwt/core/client/JsArray;)(jsarray);
			}, function (jsarray) {
				signalCallback.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/google/gwt/core/client/JsArray;)(jsarray);
			});
	}-*/;
	
}
