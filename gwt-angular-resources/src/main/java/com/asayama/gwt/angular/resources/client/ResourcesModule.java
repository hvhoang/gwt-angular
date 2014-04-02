package com.asayama.gwt.angular.resources.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


public class ResourcesModule extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            Angular.module(this);
            directive(new GwtImage());
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }
}
