package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.site.demo.client.CustomFilterDemoResources;
import com.google.gwt.resources.client.TextResource;


public class CustomFilterExampleController implements Controller {

    public static final String DEMO_URL = CustomFilterDemoResources.INSTANCE.partial().getSafeUri().asString();
    public static final TextResource VIEW_CODE = CustomFilterDemoResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = CustomFilterDemoResources.INSTANCE.controller();
    public static final TextResource FILTER_CODE = CustomFilterDemoResources.INSTANCE.filter();
    public static final TextResource MODULE_CODE = CustomFilterDemoResources.INSTANCE.module();
    
    @Override
    public void onControllerLoad() {
    }
}
