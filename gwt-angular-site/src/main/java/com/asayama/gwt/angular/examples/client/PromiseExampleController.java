package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.PromiseDemoResources;
import com.google.gwt.resources.client.TextResource;


public class PromiseExampleController implements Controller {

    public static final String DEMO_URL = PromiseDemoResources.INSTANCE.partial().getSafeUri().asString();
    public static final TextResource VIEW_CODE = PromiseDemoResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = PromiseDemoResources.INSTANCE.controller();
    public static final TextResource SERVICE_CODE = PromiseDemoResources.INSTANCE.service();
    
    @Override
    public void onControllerLoad() {
    }
}
