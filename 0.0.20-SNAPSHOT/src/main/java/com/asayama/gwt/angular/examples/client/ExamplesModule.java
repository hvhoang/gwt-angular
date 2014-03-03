package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.AbstractModule;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class ExamplesModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        GWT.log("initializing " + getClass().getName());
        Angular.module(this);
        controller(new HttpClientExample());
        controller(new OnClickEventExample());
        controller(new TextInputExample());
        controller(new UrlHashParameterExample());
    }
}
