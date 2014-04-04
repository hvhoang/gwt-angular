package com.asayama.gwt.angular.resources.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGElement;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.angular.client.q.Deferred;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.angular.client.q.SuccessCallback;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.safehtml.shared.SafeUri;


public class GwtDataResource extends AbstractDirective {
    
    private Q q;

    @Override
    public void link(final NGScope scope, final NGElement element, JSON attrs) {
        DataResource resource = scope.get(getName());
        if (resource != null) {
            SafeUri safeUri = resource.getSafeUri();
            String uri = safeUri.asString();
            Promise promise = get(uri);
            promise.success(new SuccessCallback() {
                @Override
                public void success(Object... args) {
                    Response response = (Response) args[1];
                    String text = response.getText();
                    element.append(text);
                    scope.digest();
                }
            });
            return;
        }
    }
    
    @Override
    public boolean getTransclude() {
        //TODO https://github.com/kyoken74/gwt-angular/issues/62
        return true;
    }

    protected Promise get(final String url) {
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
