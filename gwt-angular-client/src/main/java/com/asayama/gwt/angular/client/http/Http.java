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
	
	public void get(String url, final HttpCallback callback) {
		GWT.log("[GET] " + url);
		Function.Proxy successProxy = new Function.Proxy(new Function() {
			@Override
			public JavaScriptObject invoke(Object... args) {
				callback.onSuccess();
				return null;
			}
		});
		Function.Proxy errorProxy = new Function.Proxy(new Function() {
			@Override
			public JavaScriptObject invoke(Object... args) {
				callback.onError();
				return null;
			}
		});
		delegate.get(url, successProxy, errorProxy);
	}

}
class HttpImpl extends Http implements Service.Constructor {

	public HttpImpl() {
	}
	
	@Override
	public native <T extends Service, R extends JavaScriptObject> R _get(T me) /*-{
		return [ "$http", function ($http) {
			me.@com.asayama.gwt.angular.client.http.Http::setDelegate(Lcom/asayama/gwt/angular/client/http/HttpJSO;)($http);
			return $http;
		}];
	}-*/;

}
class HttpJSO extends JavaScriptObject {
	
	protected HttpJSO() {
	}

	final native void get(String url, Function.Proxy successProxy, Function.Proxy errorProxy) /*-{
		this.get(url)
			.success(function(data, status, headers, config) {
alert("HttpJSO.get.success");
				successProxy.@com.asayama.gwt.angular.client.Function.Proxy::invoke(Lcom/google/gwt/core/client/JsArray;)(null);
			}).error(function(data, status, headers, config) {
alert("HttpJSO.get.error status=" + status);
				errorProxy.@com.asayama.gwt.angular.client.Function.Proxy::invoke(Lcom/google/gwt/core/client/JsArray;)([]);
			});
	}-*/;

}
