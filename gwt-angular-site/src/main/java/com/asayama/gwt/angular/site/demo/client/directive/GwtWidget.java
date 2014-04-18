package com.asayama.gwt.angular.site.demo.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;


public class GwtWidget extends AbstractDirective {

//    @Override
//    public void link(NGScope scope, JQElement element, JSON attrs) {
//        IsWidget widget = scope.get(getName());
//        Element target = widget.asWidget().getElement();
//        String className= element.attr("class");
//        target.addClassName(className);
//        element.replaceWith(target);
//    }

    @Override
    public void link(NGScope scope, JQElement element, JSON attrs) {
        IsWidget widget = scope.get(getName());
        element.attr("id", "foo");
        RootPanel.get("foo").add(widget);
    }
}
