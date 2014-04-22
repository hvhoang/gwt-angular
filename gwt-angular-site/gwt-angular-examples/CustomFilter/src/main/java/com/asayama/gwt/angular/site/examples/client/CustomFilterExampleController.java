package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.resources.client.TextResource;


public class CustomFilterExampleController implements Controller {

    public static final String DEMO_URL = CustomFilterExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final TextResource VIEW_CODE = CustomFilterExampleResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = CustomFilterExampleResources.INSTANCE.controller();
    public static final TextResource FILTER_CODE = CustomFilterExampleResources.INSTANCE.filter();
    public static final TextResource MODULE_CODE = CustomFilterExampleResources.INSTANCE.module();
    
    @Override
    public void onControllerLoad() {
    }
}
