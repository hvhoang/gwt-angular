package com.asayama.gwt.angular.examples.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.DemoResources;
import com.google.gwt.resources.client.TextResource;


public class OnClickEventExampleController implements Controller {

    public static final String DEMO_URL = DemoResources.INSTANCE.onClickEvent().getSafeUri().asString();
    public static final TextResource VIEW_CODE = DemoResources.INSTANCE.onClickEventResources().view();
    public static final TextResource CONTROLLER_CODE = DemoResources.INSTANCE.onClickEventResources().controller();


    @Override
    public void onControllerLoad() {
    }
}
