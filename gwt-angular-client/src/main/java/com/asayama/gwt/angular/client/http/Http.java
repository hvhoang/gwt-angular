package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.JS;
import com.asayama.gwt.angular.client.Function;
import com.asayama.gwt.angular.client.Service;
import com.google.gwt.core.client.GWT;

/**
 * <ul>
 * <li>TODO use code generator, and implement as a custom service in Java
 * <li>TODO fix get
 * <li>TODO implement head, post, put, delete, and jsonp
 * </ul>
 */
public class Http implements Service {
	
	HttpJSO delegate = null;
	
	public Http() {
	}
	
	public void onServiceLoad(HttpJSO delegate) {
		this.delegate = delegate;
	}
	
	public <T extends JS> void get(final String url, final HttpCallback<T> callback) {
		GWT.log("[GET] " + url);
		delegate.get(url, new Function.Proxy<HttpResponseJSO<T>>(new Function<HttpResponseJSO<T>>() {
			@Override
			public JS invoke(HttpResponseJSO<T> response) {
				GWT.log("[" + response.getStatus() + "] " + url);
				callback.onSuccess(response);
				return null;
			}
		}), new Function.Proxy<HttpResponseJSO<T>>(new Function<HttpResponseJSO<T>>() {
			@Override
			public JS invoke(HttpResponseJSO<T> response) {
				GWT.log("[" + response.getStatus() + "] " + url);
				callback.onError(response);
				return null;
			}
		}));
	}

}
class HttpImpl extends Http implements Service.Constructor {

	public HttpImpl() {
	}
	
	@Override
	public native <R extends JS, T extends Service> R _getConstructor(T me) /*-{
		return [ "$http",
			function ($http) {
				me.@com.asayama.gwt.angular.client.http.Http::onServiceLoad(Lcom/asayama/gwt/angular/client/http/HttpJSO;)($http);
				return $http;
			}];
	}-*/;

}
class HttpJSO extends JS {
	
	protected HttpJSO() {
	}

	final native <T extends JS> void get(String url, Function.Proxy<HttpResponseJSO<T>> successProxy, Function.Proxy<HttpResponseJSO<T>> errorProxy) /*-{
		this.get(url)
			.success(function(data, status, headers, config) {
				successProxy.@com.asayama.gwt.angular.client.Function.Proxy::invoke(Lcom/asayama/gwt/angular/client/JS;)({
					'data': data||null,
					'status': status||-1,
					'headers': headers||{},
					'config': config||function(){}
				});
			}).error(function(data, status, headers, config) {
				errorProxy.@com.asayama.gwt.angular.client.Function.Proxy::invoke(Lcom/asayama/gwt/angular/client/JS;)({
					'data': data||null,
					'status': status||-1,
					'headers': headers||{},
					'config': config||function(){}
				});
			});
	}-*/;

}
