package com.asayama.gwt.angular.resources.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.resources.client.directive.GwtDataResource;
import com.asayama.gwt.angular.resources.client.directive.GwtHtmlResource;
import com.asayama.gwt.angular.resources.client.directive.GwtImageResource;
import com.asayama.gwt.angular.resources.client.directive.GwtTextResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


public class Resources extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            Angular.module(this);
            directive(GwtDataResource.class);
            directive(GwtHtmlResource.class);
            directive(GwtImageResource.class);
            directive(GwtTextResource.class);
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }
}
