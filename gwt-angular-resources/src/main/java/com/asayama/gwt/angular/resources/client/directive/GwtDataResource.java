package com.asayama.gwt.angular.resources.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGElement;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.angular.resources.client.StringTextResource;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeUri;


public class GwtDataResource extends AbstractDirective {

    @Override
    public TextResource getTemplate() {
        return new StringTextResource("hello");
    }
    
    @Override
    public void link(NGScope scope, NGElement element, JSON attrs) {
        DataResource resource = scope.get(getName());
        if (resource != null) {
            SafeUri safeUri = resource.getSafeUri();
            String uri = safeUri.asString();
            scope.put(getName(), uri);
            return;
        }
    }
}
