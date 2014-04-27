package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.resources.client.TextResource;


public class TextInputExampleController implements Controller {

    // Text Input Example Resources
    public static final String DEMO_URL = TextInputExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final TextResource VIEW_CODE = TextInputExampleResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = TextInputExampleResources.INSTANCE.controller();
    public static final TextResource CONFIG_CODE = TextInputExampleResources.INSTANCE.config();
    
    @Override
    public void onControllerLoad() {
    }
}
