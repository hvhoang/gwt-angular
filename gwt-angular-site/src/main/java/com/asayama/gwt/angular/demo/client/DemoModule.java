package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;


public class DemoModule extends AbstractModule {

    @Override
    public void onModuleLoad() {
        Angular.module(this);
    }
}
