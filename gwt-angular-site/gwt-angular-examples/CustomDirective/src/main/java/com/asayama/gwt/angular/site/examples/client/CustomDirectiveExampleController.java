package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.resources.client.TextResource;


public class CustomDirectiveExampleController implements Controller {

    public static final String DEMO_URL = CustomDirectiveExampleResources.INSTANCE.partial().getSafeUri().asString();

    public static final TextResource VIEW_CODE = CustomDirectiveExampleResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = CustomDirectiveExampleResources.INSTANCE.controller();
    public static final TextResource DIRECTIVE_CODE = CustomDirectiveExampleResources.INSTANCE.directive();
    public static final TextResource TEMPLATE_CODE = CustomDirectiveExampleResources.INSTANCE.template();
    public static final TextResource MODULE_CODE = CustomDirectiveExampleResources.INSTANCE.module();
    public static final TextResource CONFIG_CODE = CustomDirectiveExampleResources.INSTANCE.config();

    @Override
    public void onControllerLoad() {
    }
}
