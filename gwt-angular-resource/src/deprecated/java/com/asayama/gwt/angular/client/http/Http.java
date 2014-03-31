package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.Constructor;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Invoker;
import com.google.gwt.core.client.GWT;

/**
 * <ul>
 * <li>TODO use code generator, and implement as a custom service in Java
 * <li>TODO fix get
 * <li>TODO implement head, post, put, delete, and jsonp
 * </ul>
 */
public class Http implements Service, Wrapper<HttpJSO>, Constructor {

	HttpJSO delegate;
	
	public <T extends $> void head(String url, HttpCallback<T> callback) {
		delegate.send("HEAD", url, callback);
	}
	
	public <T extends $> void get(String url, HttpCallback<T> callback) {
		delegate.send("GET", url, callback);
	}
	
	public <T extends $> void put(String url, HttpCallback<T> callback) {
		delegate.send("PUT", url, callback);
	}
	
	public <T extends $> void post(String url, HttpCallback<T> callback) {
		delegate.send("POST", url, callback);
	}
	
	public <T extends $> void delete(String url, HttpCallback<T> callback) {
		delegate.send("DELETE", url, callback);
	}

	@Override
	public native $ constructor(Invoker invoker) /*-{
		return [ '$http', function ($http) {
			invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/JSArray;)([ $http ]);
			return $http; //TODO Maybe there is where the problem is. Maybe we should return Http via Invoker?
		}];
	}-*/;

	// Wrapper Methods
	
	@Override
	public HttpJSO get$() {
		return this.delegate;
	}

	@Override
	public void set$(HttpJSO delegate) {
		this.delegate = delegate;
	}

}
class HttpJSO extends $ {
	
	protected HttpJSO() {
	}

	final <T extends $> void send(String method, final String url, final HttpCallback<T> callback) {
		GWT.log("[" + method + "] " + url);
		send(method, url, new Invoker(new Closure<HttpResponseJSO<T>>() {
			public void closure(HttpResponseJSO<T> response) {
				GWT.log("[" + response.getStatus() + "] " + url);
				callback.onSuccess(response);
			}
		}), new Invoker(new Closure<HttpResponseJSO<T>>() {
			public void closure (HttpResponseJSO<T> response) {
				GWT.log("[" + response.getStatus() + "] " + url);
				callback.onError(response);
			}
		}));
	}
	
	final native <T extends $> void send(String method, String url, Invoker successInvoker, Invoker errorInvoker) /*-{
		this({ 'method':method, 'url':url })
			.success(function(data, status, headers, config) {
				successInvoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/JSArray;)({
					'data': data||null,
					'status': status||-1,
					'headers': headers||{},
					'config': config||function(){}
				});
			}).error(function(data, status, headers, config) {
				errorInvoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/JSArray;)({
					'data': data||null,
					'status': status||-1,
					'headers': headers||{},
					'config': config||function(){}
				});
			});
	}-*/;

}
