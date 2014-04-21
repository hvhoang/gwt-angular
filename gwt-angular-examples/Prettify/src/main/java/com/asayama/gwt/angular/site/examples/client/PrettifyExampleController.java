package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.resources.client.TextResource;


public class PrettifyExampleController implements Controller {

    public static final String DEMO_URL = PrettifyDemoResources.INSTANCE.demo().getSafeUri().asString();
    public static final TextResource VIEW_CODE = PrettifyDemoResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = PrettifyDemoResources.INSTANCE.controller();
    
    @Override
    public void onControllerLoad() {
    }
}
