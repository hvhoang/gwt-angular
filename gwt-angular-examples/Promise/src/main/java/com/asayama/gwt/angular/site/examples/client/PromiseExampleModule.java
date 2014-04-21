package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.site.examples.client.service.GreetingService;
import com.google.gwt.core.client.EntryPoint;

public class PromiseExampleModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        factory(GreetingService.class);
        controller(PromiseDemoController.class);
        controller(PromiseExampleController.class);
    }
}
