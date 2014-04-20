package com.asayama.gwt.angular.site.demo.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;


public class GwtWidget extends AbstractDirective {
    
    private static long counter = 0L;

    @Override
    public void link(NGScope scope, JQElement element, JSON attrs) {
        IsWidget widget = scope.get(getName());
        String id = "gwt-angular-" + counter++;
        element.attr("id", id);
        RootPanel.get(id).add(widget);
    }
}
