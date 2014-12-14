package com.asayama.gwt.angular.resources.client.directive;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.resources.client.TextResource;

/**
 * Equivalent to data-ng-bind-html directive.
 * 
 * @author kyoken74
 */
public class GwtTextResource extends AbstractDirective {

    private static final String CLASS = GwtTextResource.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);
    
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
        if (resource == null) {
            LOG.log(Level.WARNING, "Mandatory attribute " + getName() + " value is mssing");
            return;
        }
        String text = resource.getText();
        element.append(text);
    }
}
