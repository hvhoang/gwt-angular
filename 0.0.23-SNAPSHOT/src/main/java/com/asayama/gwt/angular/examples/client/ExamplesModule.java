package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;

public class ExamplesModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        filter("reverse", new ReverseFilter());
        controller(new HttpClientExample());
        controller(new OnClickEventExample());
        controller(new TextInputExample());
        controller(new UrlHashParameterExample());
        controller(new ReverseFilterExample());
    }
}
