package com.asayama.gwt.angular.widget.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.widget.client.directive.GwtWidget;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


public class WidgetModule extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            Angular.module(this);
            directive(GwtWidget.class);
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }
}
