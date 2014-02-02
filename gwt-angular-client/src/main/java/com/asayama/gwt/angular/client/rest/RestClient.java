package com.asayama.gwt.angular.client.rest;

import com.asayama.gwt.angular.client.Constructable;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.angular.client.q.Deferred;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

public class RestClient implements Service, Wrapper<Q>, Constructable {

	protected Q q;
	
	public <T extends JSObject> Request get(final String url, RestCallback<T> callback) throws RequestException {
		final Deferred<T> deferred = q.defer();
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		GWT.log("[GET] " + url);
		Request request = builder.sendRequest(null, new RequestCallback() {
			@Override
			public void onResponseReceived(Request request, Response response) {
				int status = response.getStatusCode();
				GWT.log("[" + status + "] " + url);
				if (status == 200) {
					deferred.resolve(T.<T>parse(response.getText()));
				}
			}
			@Override
			public void onError(Request request, Throwable exception) {
				GWT.log("[EXCEPTION] " + url, exception);
				deferred.reject(null);//FIXME figure out what to do here
			}
		});
		deferred.promise().then(callback);
		return request;
	}
	
	@Override
	public Q getDelegate() {
		return q;
	}

	@Override
	public void setDelegate(JSObject delegate) {
		this.q = delegate.cast();
	}
	
	// Constructor Methods
	
	@Override
	public native JSObject construct(Invoker invoker) /*-{
		return [ "$q",
			function (arguments) {
				invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/JSObject;)(arguments);
				return arguments;
			}];
	}-*/;

}
