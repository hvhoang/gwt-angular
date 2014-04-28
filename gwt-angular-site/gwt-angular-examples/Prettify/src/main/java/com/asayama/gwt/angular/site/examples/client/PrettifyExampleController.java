package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.resources.client.TextResource;


public class PrettifyExampleController implements Controller {

    public static final String DEMO_URL = PrettifyExampleResources.INSTANCE.demo().getSafeUri().asString();
    
    public static final TextResource VIEW_CODE = PrettifyExampleResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = PrettifyExampleResources.INSTANCE.controller();
    public static final TextResource CONFIG_CODE = PrettifyExampleResources.INSTANCE.config();
    
    @Override
    public void onControllerLoad() {
    }
}
