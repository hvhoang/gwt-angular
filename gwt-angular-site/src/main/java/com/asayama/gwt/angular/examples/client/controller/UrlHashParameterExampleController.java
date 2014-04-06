package com.asayama.gwt.angular.examples.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.DemoResources;
import com.google.gwt.resources.client.TextResource;


public class UrlHashParameterExampleController implements Controller {

    public static final String URL_HASH_PARAMETER_DEMO_URL = DemoResources.INSTANCE.urlHashParameter().getSafeUri().asString();
    public static final TextResource URL_HASH_PARAMETER_VIEW = DemoResources.INSTANCE.urlHashParameterResources().view();
    public static final TextResource URL_HASH_PARAMETER_CONTROLLER = DemoResources.INSTANCE.urlHashParameterResources().controller();
    
    @Override
    public void onControllerLoad() {
    }
}
