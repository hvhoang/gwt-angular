package com.asayama.gwt.angular.http.client;

import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.q.Deferred;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Q;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestBuilder.Method;
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
 * with pre-existing code.</li>
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
 * aware that the invocation should consider the possibility that the digest is
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
    
    public Promise<Response> get(String url) {
        return send(RequestBuilder.GET, url, null);
    }
    
    public Promise<Response> post(String url, String data) {
        return send(RequestBuilder.POST, url, data);
    }
    
    public Promise<Response> put(String url, String data) {
        return send(RequestBuilder.PUT, url, data);
    }
    
    public Promise<Response> delete(String url) {
        return send(RequestBuilder.DELETE, url, null);
    }

    public Promise<Response> send(Method method, String url, String data) {
        final Deferred<Response> deferred = q.defer();
        try {
            RequestCallback callback = new RequestCallback() {

                @Override
                public void onResponseReceived(Request request, Response response) {
                    deferred.resolve(response);
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    deferred.reject(exception);
                }
            };
            RequestBuilder builder = new RequestBuilder(method, url);
            
            //TODO support cancellation of requests
            //TODO https://github.com/kyoken74/gwt-angular/issues/69
            Request request = builder.sendRequest(data, callback);
            
        } catch (RequestException e) {
            deferred.reject(e);
        }
        return deferred.promise();
    }
}
