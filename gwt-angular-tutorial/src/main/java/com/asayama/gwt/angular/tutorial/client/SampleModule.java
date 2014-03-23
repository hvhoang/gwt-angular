package com.asayama.gwt.angular.tutorial.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;


public class SampleModule extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Angular.module(this);
        controller(SampleController.class);
    }
}
