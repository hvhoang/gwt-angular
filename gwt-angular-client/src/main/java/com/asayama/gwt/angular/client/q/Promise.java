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
				callback.success(jsarray);
			}
		}), new Invoker(new Closure() {
			@Override
			public void closure(JsArray<?> jsarray) {
				callback.error(jsarray);
			}
		}), new Invoker(new Closure() {
			@Override
			public void closure(JsArray<?> jsarray) {
				callback.signal(jsarray);
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

	final native void _then(Invoker successInvoker, Invoker errorInvoker, Invoker signalInvoker) /*-{
		this.then(
			function (jsarray) {
				successInvoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/google/gwt/core/client/JsArray;)(jsarray);
			}, function (jsarray) {
				errorInvoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/google/gwt/core/client/JsArray;)(jsarray);
			}, function (jsarray) {
				signalInvoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/google/gwt/core/client/JsArray;)(jsarray);
			});
	}-*/;
	
}
