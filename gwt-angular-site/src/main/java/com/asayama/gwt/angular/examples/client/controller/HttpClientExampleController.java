package com.asayama.gwt.angular.examples.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.DemoResources;
import com.google.gwt.resources.client.TextResource;


public class HttpClientExampleController implements Controller {

    public static final String HTTP_CLIENT_DEMO_URL = DemoResources.INSTANCE.httpClient().getSafeUri().asString();
    public static final TextResource HTTP_CLIENT_VIEW = DemoResources.INSTANCE.httpClientResources().view();
    public static final TextResource HTTP_CLIENT_CONTROLLER = DemoResources.INSTANCE.httpClientResources().controller();

    @Override
    public void onControllerLoad() {
    }
}
