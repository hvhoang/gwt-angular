package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.resources.client.TextResource;


public class PromiseExampleController implements Controller {

    public static final String DEMO_URL = PromiseExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final TextResource VIEW_CODE = PromiseExampleResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = PromiseExampleResources.INSTANCE.controller();
    public static final TextResource CONFIG_CODE = PromiseExampleResources.INSTANCE.config();
    public static final TextResource SERVICE_CODE = PromiseExampleResources.INSTANCE.service();
    
    @Override
    public void onControllerLoad() {
    }
}
