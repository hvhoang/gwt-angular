package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.resources.client.TextResource;


public class OnClickEventExampleController implements Controller {

    public static final String DEMO_URL = OnClickEventExampleResources.INSTANCE.demo().getSafeUri().asString();
    
    public static final TextResource VIEW_CODE = OnClickEventExampleResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = OnClickEventExampleResources.INSTANCE.controller();
    public static final TextResource CONFIG_CODE = OnClickEventExampleResources.INSTANCE.config();

    @Override
    public void onControllerLoad() {
    }
}
