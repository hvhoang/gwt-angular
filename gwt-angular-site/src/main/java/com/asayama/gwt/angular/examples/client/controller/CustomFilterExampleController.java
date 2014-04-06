package com.asayama.gwt.angular.examples.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.DemoResources;
import com.google.gwt.resources.client.TextResource;


public class CustomFilterExampleController implements Controller {

    public static final String DEMO_URL = DemoResources.INSTANCE.reverseFilter().getSafeUri().asString();
    public static final TextResource VIEW_CODE = DemoResources.INSTANCE.customFilterResources().view();
    public static final TextResource CONTROLLER_CODE = DemoResources.INSTANCE.customFilterResources().controller();
    public static final TextResource FILTER_CODE = DemoResources.INSTANCE.customFilterResources().filter();
    public static final TextResource MODULE_CODE = DemoResources.INSTANCE.customFilterResources().module();
    
    @Override
    public void onControllerLoad() {
    }
}
