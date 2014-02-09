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

/**
 * Provides HTTP client implementation based on GWT's RequestBuilder and 
 * AngularJS's promise pattern. This implementation is provided for two reasons.
 * <ol>
 * <li>The current implementation based on $http does not work. (<a href="https://github.com/kyoken74/gwt-angular/issues/16">Issue #16</a>)</li>
 * <li>To demonstrate a RequestBuilder reuse in AngularJS for the users working with preexisting code.</li>
 * </ol>
 * There are a couple of different ways to reuse RequestBuilder in AngularJS.
 * One way is to wire it to the AngularJS's promise pattern (Q) like in this
 * implementation. Another way is to invoke AngularJS's <code>$scope.$digest()
 * </code> to refresh the view once the data is retrieved from the remote 
 * server.
 * <p>
 * This code demonstrates the use of Q rather than <code>$scope</code>
 * because the wrapper around <code>$scope</code> is not yet implemented in
 * gwt-angular-core (<a href="https://github.com/kyoken74/gwt-angular/issues/6">Issue #6</a>),
 * and also because using Q is a less kludgy way to solve this problem.
 * </p><p>
 * If one must use <code>$scope.$digest</code> solution, he or she should be 
 * aware that the invocation should consider the possibiliy that the digest is
 * already in progress at the time of receiving the asynchronous response. To
 * account for this condition, the following code should be provided.
 * <pre>
if (!$scope.$$phase) {
  $scope.$digest()
}
 * </pre>
 * </p>
 * <h3>Known Issues:</h3>
 * <ul>
 * <li><a href="https://github.com/kyoken74/gwt-angular/issues/3">Inject Q into Http automatically.</a></li>
 * </ul>
 * 
 * @author kyoken74
 * @see Q
 * @see Promise
 */
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
