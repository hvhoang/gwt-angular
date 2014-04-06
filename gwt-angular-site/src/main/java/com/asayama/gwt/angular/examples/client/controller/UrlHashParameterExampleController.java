package com.asayama.gwt.angular.examples.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.UrlHashParameterDemoResources;
import com.google.gwt.resources.client.TextResource;


public class UrlHashParameterExampleController implements Controller {

    public static final String DEMO_URL = UrlHashParameterDemoResources.INSTANCE.partial().getSafeUri().asString();
    public static final TextResource VIEW_CODE = UrlHashParameterDemoResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = UrlHashParameterDemoResources.INSTANCE.controller();
    
    @Override
    public void onControllerLoad() {
    }
}
