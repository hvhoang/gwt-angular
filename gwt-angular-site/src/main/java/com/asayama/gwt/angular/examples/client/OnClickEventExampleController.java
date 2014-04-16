package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.OnClickEventDemoResources;
import com.google.gwt.resources.client.TextResource;


public class OnClickEventExampleController implements Controller {

    public static final String DEMO_URL = OnClickEventDemoResources.INSTANCE.partial().getSafeUri().asString();
    public static final TextResource VIEW_CODE = OnClickEventDemoResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = OnClickEventDemoResources.INSTANCE.controller();

    @Override
    public void onControllerLoad() {
    }
}
