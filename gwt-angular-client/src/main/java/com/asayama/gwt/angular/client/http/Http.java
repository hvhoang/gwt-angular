package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.Invoker;
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
	
	public <T extends $> void get(final String url, final HttpCallback<T> callback) {
		GWT.log("[GET] " + url);
		delegate.get(url, new Invoker<HttpResponseJSO<T>>(new Function<HttpResponseJSO<T>>() {
			public $ call(HttpResponseJSO<T> response) {
				GWT.log("[" + response.getStatus() + "] " + url);
				callback.onSuccess(response);
				return null;
			}
		}), new Invoker<HttpResponseJSO<T>>(new Function<HttpResponseJSO<T>>() {
			public $ call(HttpResponseJSO<T> response) {
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
	public native <T extends Service> $ _getConstructor(T me) /*-{
		return [ "$http",
			function ($http) {
				me.@com.asayama.gwt.angular.client.http.Http::onServiceLoad(Lcom/asayama/gwt/angular/client/http/HttpJSO;)($http);
				return $http;
			}];
	}-*/;

}
class HttpJSO extends $ {
	
	protected HttpJSO() {
	}

	final native <T extends $> void get(String url, Invoker<HttpResponseJSO<T>> successInvoker, Invoker<HttpResponseJSO<T>> errorInvoker) /*-{
		this.get(url)
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
