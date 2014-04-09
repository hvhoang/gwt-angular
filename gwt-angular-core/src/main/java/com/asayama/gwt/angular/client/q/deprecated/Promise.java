package com.asayama.gwt.angular.client.q.deprecated;

import com.asayama.gwt.jsni.client.Closure;
import com.asayama.gwt.jsni.client.Invoker;
import com.asayama.gwt.jsni.client.JSObject;

@Deprecated
public class Promise extends JSObject {

	protected Promise() {
	}
	
	public final Promise then(final PromiseCallback callback) {
		_then(new Invoker(new Closure() {
			@Override
			public void exec(Object... args) {
				callback.success(args);
			}
		}), new Invoker(new Closure() {
			@Override
			public void exec(Object... args) {
				callback.error(args);
			}
		}), new Invoker(new Closure() {
			@Override
			public void exec(Object... args) {
				callback.notify(args);
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

	final native void _then(Invoker successInvoker, Invoker errorInvoker, Invoker notifyInvoker) /*-{
		this.then(
			function (jsarray) {
				successInvoker.@com.asayama.gwt.jsni.client.Invoker::invoke(Lcom/asayama/gwt/jsni/client/JSArray;)(jsarray);
			}, function (jsarray) {
				errorInvoker.@com.asayama.gwt.jsni.client.Invoker::invoke(Lcom/asayama/gwt/jsni/client/JSArray;)(jsarray);
			}, function (jsarray) {
				notifyInvoker.@com.asayama.gwt.jsni.client.Invoker::invoke(Lcom/asayama/gwt/jsni/client/JSArray;)(jsarray);
			});
	}-*/;
	
}
