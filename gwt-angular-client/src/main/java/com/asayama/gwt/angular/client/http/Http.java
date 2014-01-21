package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.Function;
import com.asayama.gwt.angular.client.Service;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;

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
	
	public void setDelegate(HttpJSO delegate) {
		this.delegate = delegate;
	}
	
	public <T extends JavaScriptObject> void get(final String url, final HttpCallback<T> callback) {
		GWT.log("[GET] " + url);
		delegate.get(url, new Function.Proxy<JavaScriptObject,HttpResponseJSO<T>>(new Function<JavaScriptObject,HttpResponseJSO<T>>() {
			@Override
			public JavaScriptObject invoke(HttpResponseJSO<T> response) {
				GWT.log("[" + response.getStatus() + "] " + url);
				callback.onSuccess(response);
				return null;
			}
		}), new Function.Proxy<JavaScriptObject,HttpResponseJSO<T>>(new Function<JavaScriptObject,HttpResponseJSO<T>>() {
			@Override
			public JavaScriptObject invoke(HttpResponseJSO<T> response) {
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
	public native <T extends Service, R extends JavaScriptObject> R _getConstructor(T me) /*-{
		return [ "$http",
			function ($http) {
				me.@com.asayama.gwt.angular.client.http.Http::setDelegate(Lcom/asayama/gwt/angular/client/http/HttpJSO;)($http);
				return $http;
			}];
	}-*/;

}
class HttpJSO extends JavaScriptObject {
	
	protected HttpJSO() {
	}

	final native <T extends JavaScriptObject> void get(String url, Function.Proxy<JavaScriptObject,HttpResponseJSO<T>> successProxy, Function.Proxy<JavaScriptObject,HttpResponseJSO<T>> errorProxy) /*-{
		this.get(url)
			.success(function(data, status, headers, config) {
				successProxy.@com.asayama.gwt.angular.client.Function.Proxy::invoke(Lcom/google/gwt/core/client/JavaScriptObject;)({
					'data': data||null,
					'status': status||-1,
					'headers': headers||{},
					'config': config||function(){}
				});
			}).error(function(data, status, headers, config) {
				errorProxy.@com.asayama.gwt.angular.client.Function.Proxy::invoke(Lcom/google/gwt/core/client/JavaScriptObject;)({
					'data': data||null,
					'status': status||-1,
					'headers': headers||{},
					'config': config||function(){}
				});
			});
	}-*/;

}
