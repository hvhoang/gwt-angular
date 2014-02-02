package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.AngularJSO;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.GWT;

@Bind("$http")
public class Http extends AngularJSO implements Service /*, Constructor*/ {

	protected Http() {
	}

	public final <T extends JSObject> void head(String url, HttpCallback<T> callback) {
		send("HEAD", url, null, callback);
	}
	
	public final <T extends JSObject> void get(String url, HttpCallback<T> callback) {
		send("GET", url, null, callback);
	}
	
	public final <T extends JSObject> void put(String url, String data, HttpCallback<T> callback) {
		send("PUT", url, data, callback);
	}
	
	public final <T extends JSObject> void post(String url, String data, HttpCallback<T> callback) {
		send("POST", url, data, callback);
	}
	
	public final <T extends JSObject> void delete(String url, HttpCallback<T> callback) {
		send("DELETE", url, null, callback);
	}

	final <T extends JSObject> void send(String method, final String url, final String data, final HttpCallback<T> callback) {
		GWT.log("[" + method + "] " + url);
		_send(method, url, data, new Invoker(new Closure<HttpResponse<T>>() {
			public void closure(HttpResponse<T> response) {
				GWT.log("[" + response.getStatus() + "] " + url);
				try {
					callback.onSuccess(response);
				} catch (Exception e) {
					GWT.log("Exception while calling onSuccess()", e);
				}
			}
		}), new Invoker(new Closure<HttpResponse<T>>() {
			public void closure (HttpResponse<T> response) {
				GWT.log("[" + response.getStatus() + "] " + url);
				try {
					callback.onError(response);
				} catch (Exception e) {
					GWT.log("Exception while calling onError()", e);
				}
			}
		}));
	}
	
	final native <T extends JSObject> void _send(String method, String url, String data, Invoker successInvoker, Invoker errorInvoker) /*-{
		this({ 'method':method, 'url':url, 'data':data })
			.success(function(data, status, headers, config) {
				successInvoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/JSObject;)({
					'data': data||null,
					'status': status||-1,
					'headers': headers||{},
					'config': config||function(){}
				});
			}).error(function(data, status, headers, config) {
				errorInvoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/JSObject;)({
					'data': data||null,
					'status': status||-1,
					'headers': headers||{},
					'config': config||function(){}
				});
			});
	}-*/;

//	@Override
//	public final JSObject construct(Invoker invoker) {
//		return getConstructor(invoker, "$http");
//	}

}
