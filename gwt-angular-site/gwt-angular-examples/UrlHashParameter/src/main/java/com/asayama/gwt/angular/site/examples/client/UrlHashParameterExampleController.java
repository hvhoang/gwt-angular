package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;


public class UrlHashParameterExampleController implements Controller {

    public static final String DEMO_URL = UrlHashParameterExampleResources.INSTANCE.demo().getSafeUri().asString();
    
    @Override
    public void onControllerLoad() {
    }
}
