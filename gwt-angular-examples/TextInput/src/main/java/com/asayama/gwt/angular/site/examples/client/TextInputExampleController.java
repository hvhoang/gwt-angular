package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.resources.client.TextResource;


public class TextInputExampleController implements Controller {

    // Text Input Example Resources
    public static final String DEMO_URL = TextInputDemoResources.INSTANCE.partial().getSafeUri().asString();
    public static final TextResource VIEW_CODE = TextInputDemoResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = TextInputDemoResources.INSTANCE.controller();
    
    @Override
    public void onControllerLoad() {
    }
}
