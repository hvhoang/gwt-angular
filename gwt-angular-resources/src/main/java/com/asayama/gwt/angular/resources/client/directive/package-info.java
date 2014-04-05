package com.asayama.gwt.angular.resources.client.directive;

import com.asayama.gwt.angular.client.q.Deferred;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Q;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

class HttpUtils {

    static Promise get(Q q, final String url) {
        final Deferred deferred = q.defer();
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
        try {
            deferred.notify(builder.sendRequest(null, new RequestCallback() {

                @Override
                public void onResponseReceived(Request request, Response response) {
                    deferred.resolve(request, response);
                }

                @Override
                public void onError(Request request, Throwable exception) {
                    deferred.reject(request, exception);
                }
            }));
        } catch (RequestException e) {
            deferred.reject(null, e);
        }
        return deferred.promise();
    }
}