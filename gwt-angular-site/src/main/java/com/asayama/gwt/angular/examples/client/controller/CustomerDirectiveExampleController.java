package com.asayama.gwt.angular.examples.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.DemoResources;
import com.google.gwt.resources.client.TextResource;


public class CustomerDirectiveExampleController implements Controller {

    public static final String CUSTOM_DIRECTIVE_DEMO_URL = DemoResources.INSTANCE.customDirectiveExample().getSafeUri().asString();
    public static final TextResource CUSTOM_DIRECTIVE_VIEW = DemoResources.INSTANCE.customDirectiveResources().view();
    public static final TextResource CUSTOM_DIRECTIVE_CONTROLLER = DemoResources.INSTANCE.customDirectiveResources().controller();
    public static final TextResource CUSTOM_DIRECTIVE_DIRECTIVE = DemoResources.INSTANCE.customDirectiveResources().directive();
    public static final TextResource CUSTOM_DIRECTIVE_TEMPLATE = DemoResources.INSTANCE.customDirectiveResources().template();
    public static final TextResource CUSTOM_DIRECTIVE_MODULE = DemoResources.INSTANCE.customDirectiveResources().module();

    @Override
    public void onControllerLoad() {
    }
}
