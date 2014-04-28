package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;

@Deprecated
public class GwtWidgetsExampleController implements Controller {

    public static final String DEMO_URL = GwtWidgetsExampleResources.INSTANCE.demo().getSafeUri().asString();
    
    @Override
    public void onControllerLoad() {
    }
}
