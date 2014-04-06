package com.asayama.gwt.angular.examples.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.DemoResources;
import com.google.gwt.resources.client.TextResource;


public class CustomFilterExampleController implements Controller {

    public static final String CUSTOM_FILTER_DEMO_URL = DemoResources.INSTANCE.reverseFilter().getSafeUri().asString();
    public static final TextResource CUSTOM_FILTER_VIEW = DemoResources.INSTANCE.customFilterResources().view();
    public static final TextResource CUSTOM_FILTER_CONTROLLER = DemoResources.INSTANCE.customFilterResources().controller();
    public static final TextResource CUSTOM_FILTER_FILTER = DemoResources.INSTANCE.customFilterResources().filter();
    public static final TextResource CUSTOM_FILTER_MODULE = DemoResources.INSTANCE.customFilterResources().module();
    
    @Override
    public void onControllerLoad() {
    }
}
