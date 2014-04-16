package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.PrettifyDemoResources;
import com.google.gwt.resources.client.TextResource;


public class PrettifyExampleController implements Controller {

    public static final String DEMO_URL = PrettifyDemoResources.INSTANCE.partial().getSafeUri().asString();
    public static final TextResource VIEW_CODE = PrettifyDemoResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = PrettifyDemoResources.INSTANCE.controller();
    
    @Override
    public void onControllerLoad() {
    }
}
