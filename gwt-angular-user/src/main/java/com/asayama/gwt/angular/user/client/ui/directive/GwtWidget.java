package com.asayama.gwt.angular.user.client.ui.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 
 * 
 * @author kyoken74
 */
public class GwtWidget extends AbstractDirective {
    
    private static long counter = 0L;

    /**
     * Creates isolateScope and registers the following attribute definition.
     * <ul>
     * <li>{@code IsWidget} gwt-widget</li>
     * </ul>
     */
    @Override
    public NGScope scope() {
        NGScope scope = NGScope.create();
        scope.put(getName(), "=");
        return scope;
    }

    /**
     * Replaces the element body with the GWT widget passed via gwt-widget
     * attribute. GWT widget must implement IsWidget interface.
     */
    @Override
    public void link(NGScope scope, JQElement element, JSON attrs) {
        IsWidget widget = scope.get(getName());
        String id = "gwt-widget-" + counter++;
        element.attr("id", id);
        RootPanel.get(id).add(widget);
    }
}
