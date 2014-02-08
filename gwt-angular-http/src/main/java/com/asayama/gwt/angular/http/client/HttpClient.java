package com.asayama.gwt.angular.http.client;

import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.q.Deferred;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Q;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

public class HttpClient implements Service {

	protected Q q; //FIXME https://github.com/kyoken74/gwt-angular/issues/3
	
	public void get(String url, HttpClientCallback callback) throws RequestException {
		Promise promise = get(url);
		promise.then(callback);
	}
	
	public Promise get(final String url) throws RequestException {
		final Deferred deferred = q.defer();
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		GWT.log("[GET] " + url);
		deferred.notify(
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
			})
		);
		return deferred.promise();
	}
	
	public void post(String url, String data, HttpClientCallback callback) throws RequestException {
		Promise promise = post(url, data);
		promise.then(callback);
	}
	
	public Promise post(final String url, String data) throws RequestException {
		final Deferred deferred = q.defer();
		RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
		GWT.log("[POST] " + url);
		deferred.notify(
			builder.sendRequest(data, new RequestCallback() {
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
			})
		);
		return deferred.promise();
	}

	public void put(String url, String data, HttpClientCallback callback) throws RequestException {
		Promise promise = put(url, data);
		promise.then(callback);
	}
	
	public Promise put(final String url, String data) throws RequestException {
		final Deferred deferred = q.defer();
		RequestBuilder builder = new RequestBuilder(RequestBuilder.PUT, url);
		GWT.log("[POST] " + url);
		deferred.notify(
			builder.sendRequest(data, new RequestCallback() {
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
			})
		);
		return deferred.promise();
	}

	public void delete(String url, HttpClientCallback callback) throws RequestException {
		Promise promise = delete(url);
		promise.then(callback);
	}
	
	public Promise delete(final String url) throws RequestException {
		final Deferred deferred = q.defer();
		RequestBuilder builder = new RequestBuilder(RequestBuilder.DELETE, url);
		GWT.log("[DELETE] " + url);
		deferred.notify(
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
			})
		);
		return deferred.promise();
	}

	// Getters and Setters
	
	public Q getQ() {
		return q;
	}
	public void setQ(Q q) {
		this.q = q;
	}

}
