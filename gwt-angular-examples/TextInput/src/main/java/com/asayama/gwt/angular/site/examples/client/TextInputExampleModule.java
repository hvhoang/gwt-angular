package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;

public class TextInputExampleModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        controller(TextInputDemoController.class);
        controller(TextInputExampleController.class);
    }
}
