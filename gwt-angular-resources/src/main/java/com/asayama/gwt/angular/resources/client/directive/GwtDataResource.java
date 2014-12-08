package com.asayama.gwt.angular.resources.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Promise.Done;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Response;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.safehtml.shared.SafeUri;


public class GwtDataResource extends AbstractDirective {
    
	@Injector.Inject
    private Q q;

    @Override
    public void link(final NGScope scope, final JQElement element, JSON attrs) {
        DataResource resource = scope.get(getName());
        if (resource == null) {
        	GWT.log("Mandatory attribute " + getName() + " value is mssing");
        	return;
        }
        SafeUri safeUri = resource.getSafeUri();
        String url = safeUri.asString();
        Promise<Response> promise = HttpUtils.get(q, url);
        promise.then(new Done<Response>() {
            @Override
            public void call(Response value) {
                String text = value.getText();
                element.append(text);
            }
        });
        return;
    }
}
