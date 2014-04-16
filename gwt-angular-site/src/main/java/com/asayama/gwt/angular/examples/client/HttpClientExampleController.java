package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.HttpClientDemoResources;
import com.google.gwt.resources.client.TextResource;


public class HttpClientExampleController implements Controller {

    public static final String DEMO_URL = HttpClientDemoResources.INSTANCE.partial().getSafeUri().asString();
    public static final TextResource VIEW_CODE = HttpClientDemoResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = HttpClientDemoResources.INSTANCE.controller();

    @Override
    public void onControllerLoad() {
    }
}
