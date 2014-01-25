package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Invoker;
import com.google.gwt.core.client.GWT;

public class Http extends $ implements Service {

	protected Http() {
	}

	public final <T extends $> void head(String url, HttpCallback<T> callback) {
		send("HEAD", url, callback);
	}
	
	public final <T extends $> void get(String url, HttpCallback<T> callback) {
		send("GET", url, callback);
	}
	
	public final <T extends $> void put(String url, HttpCallback<T> callback) {
		send("PUT", url, callback);
	}
	
	public final <T extends $> void post(String url, HttpCallback<T> callback) {
		send("POST", url, callback);
	}
	
	public final <T extends $> void delete(String url, HttpCallback<T> callback) {
		send("DELETE", url, callback);
	}

	final <T extends $> void send(String method, final String url, final HttpCallback<T> callback) {
		GWT.log("[" + method + "] " + url);
		send(method, url, new Invoker(new Closure<HttpResponse<T>>() {
			public void closure(HttpResponse<T> response) {
				GWT.log("[" + response.getStatus() + "] " + url);
				callback.onSuccess(response);
			}
		}), new Invoker(new Closure<HttpResponse<T>>() {
			public void closure (HttpResponse<T> response) {
				GWT.log("[" + response.getStatus() + "] " + url);
				callback.onError(response);
			}
		}));
	}
	
	final native <T extends $> void send(String method, String url, Invoker successInvoker, Invoker errorInvoker) /*-{
		this({ 'method':method, 'url':url })
			.success(function(data, status, headers, config) {
				successInvoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/$;)({
					'data': data||null,
					'status': status||-1,
					'headers': headers||{},
					'config': config||function(){}
				});
			}).error(function(data, status, headers, config) {
				errorInvoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/$;)({
					'data': data||null,
					'status': status||-1,
					'headers': headers||{},
					'config': config||function(){}
				});
			});
	}-*/;

}
