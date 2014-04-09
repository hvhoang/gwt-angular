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
 * <li>The current implementation based on $http does not work. (<a
 * href="https://github.com/kyoken74/gwt-angular/issues/16">Issue #16</a>)</li>
 * <li>To demonstrate a RequestBuilder reuse in AngularJS for the users working
 * with preexisting code.</li>
 * </ol>
 * There are a couple of different ways to reuse RequestBuilder in AngularJS.
 * One way is to wire it to the AngularJS's promise pattern (Q) like in this
 * implementation. Another way is to invoke AngularJS's <code>$scope.$digest()
 * </code> to refresh the view once the data is retrieved from the remote
 * server.
 * <p>
 * This code demonstrates the use of Q rather than <code>$scope</code> because
 * the wrapper around <code>$scope</code> is not yet implemented in
 * gwt-angular-core (<a
 * href="https://github.com/kyoken74/gwt-angular/issues/6">Issue #6</a>), and
 * also because using Q is a less kludgy way to solve this problem.
 * </p>
 * <p>
 * If one must use <code>$scope.$digest</code> solution, he or she should be
 * aware that the invocation should consider the possibiliy that the digest is
 * already in progress at the time of receiving the asynchronous response. To
 * account for this condition, the following code should be provided.
 * 
 * <pre>
 * if (!$scope.$$phase) {
 *   $scope.$digest()
 * }
 * </pre>
 * 
 * </p>
 * 
 * @author kyoken74
 * @see Q
 * @see Promise
 */
public class HttpClient implements Service {

    private Q q;

    public Promise<Response> get(final String url) {
        final Deferred<Response> deferred = q.defer();
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
        GWT.log("[GET] " + url);
        try {
            builder.sendRequest(null, new RequestCallback() {

                @Override
                public void onResponseReceived(Request request, Response response) {
                    try {
                        int status = response.getStatusCode();
                        GWT.log("[" + status + "] " + url);
                        deferred.resolve(response);
                    } catch (Exception e) {
                        GWT.log("[GET]" + url, e);
                    }
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    GWT.log("[ERR] " + url, exception);
                    deferred.reject(exception);
                }
            });
        } catch (RequestException e) {
            deferred.reject(e);
        }
        return deferred.promise();
    }

    public Promise<Response> post(final String url, String data) {
        final Deferred<Response> deferred = q.defer();
        RequestBuilder builder = new RequestBuilder(RequestBuilder.POST, url);
        GWT.log("[POST] " + url);
        try {
            builder.sendRequest(data, new RequestCallback() {

                @Override
                public void onResponseReceived(Request request, Response response) {
                    int status = response.getStatusCode();
                    GWT.log("[" + status + "] " + url);
                    deferred.resolve(response);
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    GWT.log("[ERR] " + url, exception);
                    deferred.reject(exception);
                }
            });
        } catch (RequestException e) {
            deferred.reject(e);
        }
        return deferred.promise();
    }

    public Promise<Response> put(final String url, String data) {
        final Deferred<Response> deferred = q.defer();
        RequestBuilder builder = new RequestBuilder(RequestBuilder.PUT, url);
        GWT.log("[POST] " + url);
        try {
            builder.sendRequest(data, new RequestCallback() {

                @Override
                public void onResponseReceived(Request request, Response response) {
                    int status = response.getStatusCode();
                    GWT.log("[" + status + "] " + url);
                    deferred.resolve(response);
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    GWT.log("[ERR] " + url, exception);
                    deferred.reject(exception);
                }
            });
        } catch (RequestException e) {
            deferred.reject(e);
        }
        return deferred.promise();
    }

    public Promise<Response> delete(final String url) {
        final Deferred<Response> deferred = q.defer();
        RequestBuilder builder = new RequestBuilder(RequestBuilder.DELETE, url);
        GWT.log("[DELETE] " + url);
        try {
            builder.sendRequest(null, new RequestCallback() {

                @Override
                public void onResponseReceived(Request request, Response response) {
                    int status = response.getStatusCode();
                    GWT.log("[" + status + "] " + url);
                    deferred.resolve(response);
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    GWT.log("[ERR] " + url, exception);
                    deferred.reject(exception);
                }
            });
        } catch (RequestException e) {
            deferred.reject(e);
        }
        return deferred.promise();
    }
}
