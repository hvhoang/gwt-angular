package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.CustomDirectiveDemoResources;
import com.google.gwt.resources.client.TextResource;


public class CustomerDirectiveExampleController implements Controller {

    public static final String DEMO_URL = CustomDirectiveDemoResources.INSTANCE.partial().getSafeUri().asString();
    public static final TextResource VIEW_CODE = CustomDirectiveDemoResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = CustomDirectiveDemoResources.INSTANCE.controller();
    public static final TextResource DIRECTIVE_CODE = CustomDirectiveDemoResources.INSTANCE.directive();
    public static final TextResource TEMPLATE_CODE = CustomDirectiveDemoResources.INSTANCE.template();
    public static final TextResource MODULE_CODE = CustomDirectiveDemoResources.INSTANCE.module();

    @Override
    public void onControllerLoad() {
    }
}
