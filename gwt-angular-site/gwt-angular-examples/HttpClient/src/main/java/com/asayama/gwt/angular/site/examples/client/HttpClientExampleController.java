package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.resources.client.TextResource;


public class HttpClientExampleController implements Controller {

    public static final String DEMO_URL = HttpClientExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final TextResource VIEW_CODE = HttpClientExampleResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = HttpClientExampleResources.INSTANCE.controller();
    public static final TextResource CONFIG_CODE = HttpClientExampleResources.INSTANCE.config();

    @Override
    public void onControllerLoad() {
    }
}
