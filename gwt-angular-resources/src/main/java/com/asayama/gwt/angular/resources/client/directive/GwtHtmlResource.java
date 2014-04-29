package com.asayama.gwt.angular.resources.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Promise.Done;
import com.asayama.gwt.angular.client.q.Promise.Fail;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Response;

/**
 * Equivalent to data-ng-include directive.
 * 
 * @author kyoken74
 */
public class GwtHtmlResource extends AbstractDirective {
    
    private Q q;
    
    /**
     * Creates isolateScope and registers the following attribute definition.
     * <ul>
     * <li>{@code ImageResource} gwt-html-resource</li>
     * </ul>
     */
    @Override
    public NGScope scope() {
    	NGScope scope = NGScope.create();
    	scope.put(getName(), "=");
    	return scope;
    }

    @Override
    public void link(final NGScope scope, final JQElement element, JSON attrs) {
        HtmlResource resource = scope.get(getName());
        if (resource == null) {
        	GWT.log("Mandatory attribute " + getName() + " value is mssing");
        	return;
        }
        String url = resource.getSafeUri().asString();
        Promise<Response> promise = HttpUtils.get(q, url);
        promise.then(new Done<Response>() {
            @Override
            public void call(Response value) {
                String text = value.getText();
                element.append(text);
            }
        }).then(new Fail() {
        	@Override
        	public void call(Throwable cause) {
        		GWT.log("Failed to insert HtmlResource", cause);
        	}
        });
        return;
    }
}
