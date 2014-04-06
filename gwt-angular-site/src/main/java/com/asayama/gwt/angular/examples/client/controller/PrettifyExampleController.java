package com.asayama.gwt.angular.examples.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.DemoResources;
import com.google.gwt.resources.client.TextResource;


public class PrettifyExampleController implements Controller {

    public static final String PRETTIFY_DEMO_URL = DemoResources.INSTANCE.prettify().getSafeUri().asString();
    public static final TextResource PRETTIFY_VIEW = DemoResources.INSTANCE.prettifyResources().view();
    public static final TextResource PRETTIFY_CONTROLLER = DemoResources.INSTANCE.prettifyResources().controller();
    
    @Override
    public void onControllerLoad() {
    }
}
