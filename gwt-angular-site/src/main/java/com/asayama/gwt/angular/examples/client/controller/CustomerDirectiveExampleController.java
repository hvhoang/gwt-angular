package com.asayama.gwt.angular.examples.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.DemoResources;
import com.google.gwt.resources.client.TextResource;


public class CustomerDirectiveExampleController implements Controller {

    public static final String DEMO_URL = DemoResources.INSTANCE.customDirectiveExample().getSafeUri().asString();
    public static final TextResource VIEW_CODE = DemoResources.INSTANCE.customDirectiveResources().view();
    public static final TextResource CONTROLLER_CODE = DemoResources.INSTANCE.customDirectiveResources().controller();
    public static final TextResource DIRECTIVE_CODE = DemoResources.INSTANCE.customDirectiveResources().directive();
    public static final TextResource TEMPLATE_CODE = DemoResources.INSTANCE.customDirectiveResources().template();
    public static final TextResource MODULE_CODE = DemoResources.INSTANCE.customDirectiveResources().module();

    @Override
    public void onControllerLoad() {
    }
}
