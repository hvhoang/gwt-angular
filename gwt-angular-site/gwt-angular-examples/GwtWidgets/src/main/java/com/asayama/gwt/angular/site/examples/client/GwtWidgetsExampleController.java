package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.resources.client.TextResource;


public class GwtWidgetsExampleController implements Controller {

    // Text Input Example Resources
    public static final String DEMO_URL = GwtWidgetsExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final TextResource VIEW_CODE = GwtWidgetsExampleResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = GwtWidgetsExampleResources.INSTANCE.controller();
    
    @Override
    public void onControllerLoad() {
    }
}
