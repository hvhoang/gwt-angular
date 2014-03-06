package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;

public class ExamplesModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        GWT.log("initializing " + getClass().getName());
        GWT.runAsync(ExamplesModule.class, new RunAsyncCallback() {
            @Override
            public void onSuccess() {
                Angular.module(ExamplesModule.this);
                filter("reverse", new ReverseFilter());
                controller(new HttpClientExample());
                controller(new OnClickEventExample());
                controller(new TextInputExample());
                controller(new UrlHashParameterExample());
                controller(new ReverseFilterExample());
            }
            @Override
            public void onFailure(Throwable reason) {
                GWT.log("Failed to load " + ExamplesModule.class.getName(), reason);
            }
        });
    }
}
