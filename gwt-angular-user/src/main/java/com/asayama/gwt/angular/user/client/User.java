package com.asayama.gwt.angular.user.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.user.client.ui.directive.GwtWidget;
import com.google.gwt.core.client.EntryPoint;


public class User extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Angular.module(this);
        directive(GwtWidget.class);
    }
}
