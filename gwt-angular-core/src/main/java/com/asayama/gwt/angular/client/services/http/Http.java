package com.asayama.gwt.angular.client.services.http;

import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.services.q.Deferred;
import com.asayama.gwt.angular.client.services.q.Promise;
import com.asayama.gwt.angular.client.services.q.Q;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

public class Http implements Service {

	protected Q q; //TODO Must figure out dependency injection

	public void get(final String url, HttpCallback callback) throws RequestException {
		Promise promise = get(url);
		promise.then(callback);
	}
	
	public Promise get(final String url) throws RequestException {
		final Deferred deferred = q.defer();
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		GWT.log("[GET] " + url);
		builder.sendRequest(null, new RequestCallback() {
			@Override
			public void onResponseReceived(Request request, Response response) {
				int status = response.getStatusCode();
				GWT.log("[" + status + "] " + url);
				deferred.resolve(request, response);
			}
			@Override
			public void onError(Request request, Throwable exception) {
				GWT.log("[ERR] " + url, exception);
				deferred.reject(request, exception);
			}
		});
		return deferred.promise();
	}

	
}
