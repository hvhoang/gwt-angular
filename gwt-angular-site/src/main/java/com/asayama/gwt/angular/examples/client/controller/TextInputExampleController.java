package com.asayama.gwt.angular.examples.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.TextInputDemoResources;
import com.google.gwt.resources.client.TextResource;


public class TextInputExampleController implements Controller {

    // Text Input Example Resources
    public static final String DEMO_URL = TextInputDemoResources.INSTANCE.textInput().getSafeUri().asString();
    public static final TextResource VIEW_CODE = TextInputDemoResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = TextInputDemoResources.INSTANCE.controller();
    
    @Override
    public void onControllerLoad() {
    }
}
