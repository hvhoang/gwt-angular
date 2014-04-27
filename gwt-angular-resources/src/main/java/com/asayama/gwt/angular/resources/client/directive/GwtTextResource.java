package com.asayama.gwt.angular.resources.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.resources.client.TextResource;


public class GwtTextResource extends AbstractDirective {

    /**
     * Creates isolateScope and registers the following attribute definition.
     * <ul>
     * <li>{@code TextResource} gwt-text-resource</li>
     * </ul>
     */
    @Override
    public NGScope scope() {
    	NGScope scope = NGScope.create();
    	scope.put(getName(), "=");
    	return scope;
    }
	
    @Override
    public void link(NGScope scope, JQElement element, JSON attrs) {
        TextResource resource = scope.get(getName());
        if (resource != null) {
            String text = resource.getText();
            element.append(text);
        }
    }
}
