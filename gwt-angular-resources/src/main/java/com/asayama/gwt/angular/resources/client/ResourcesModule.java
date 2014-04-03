package com.asayama.gwt.angular.resources.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.resources.client.directive.GwtDataResource;
import com.asayama.gwt.angular.resources.client.directive.GwtImageResource;
import com.asayama.gwt.angular.resources.client.directive.GwtTextResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


public class ResourcesModule extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            Angular.module(this);
            directive(new GwtDataResource());
            directive(new GwtImageResource());
            directive(new GwtTextResource());
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }
}
