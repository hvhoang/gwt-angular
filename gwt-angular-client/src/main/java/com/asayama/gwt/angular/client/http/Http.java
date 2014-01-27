package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Invoker;
import com.google.gwt.core.client.GWT;

@Bind("$http")
public class Http extends $ implements Service /*, Constructor*/ {

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
		$send(method, url, new Invoker(new Closure<HttpResponse<T>>() {
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
	
	final native <T extends $> void $send(String method, String url, Invoker successInvoker, Invoker errorInvoker) /*-{
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

	// Constructor Method
	//
	// com.google.gwt.dev.jjs.InternalCompilerException: Already seen an 
	// implementing JSO subtype (Http) for interface (Constructor) while 
	// examining newly-added type (Q). This is a bug in JSORestrictionsChecker.
	//
	// https://code.google.com/p/google-web-toolkit/issues/detail?id=4859
	//
	
//	@Override
//	public final native $ constructor(Invoker invoker) /*-{
//		return [ '$http', function($http) {
//			invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/$;)($http);
//			return $http;
//		}];
//	}-*/;

}
