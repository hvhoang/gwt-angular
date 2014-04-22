package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.resources.client.TextResource;


public class UrlHashParameterExampleController implements Controller {

    public static final String DEMO_URL = UrlHashParameterExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final TextResource VIEW_CODE = UrlHashParameterExampleResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = UrlHashParameterExampleResources.INSTANCE.controller();
    
    @Override
    public void onControllerLoad() {
    }
}
