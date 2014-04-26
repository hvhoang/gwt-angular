package com.asayama.gwt.angular.ui.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.ui.client.directive.GwtWidget;
import com.google.gwt.core.client.EntryPoint;


public class UIModule extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Angular.module(this);
        directive(GwtWidget.class);
    }
}
