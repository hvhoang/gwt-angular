package com.asayama.gwt.angular.examples.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.ImageResourceDemoResources;
import com.google.gwt.resources.client.TextResource;


public class ImageResourceExampleController implements Controller {

    public static final String DEMO_URL = ImageResourceDemoResources.INSTANCE.partial().getSafeUri().asString();
    public static final TextResource VIEW_CODE = ImageResourceDemoResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = ImageResourceDemoResources.INSTANCE.controller();

    @Override
    public void onControllerLoad() {
    }
}
