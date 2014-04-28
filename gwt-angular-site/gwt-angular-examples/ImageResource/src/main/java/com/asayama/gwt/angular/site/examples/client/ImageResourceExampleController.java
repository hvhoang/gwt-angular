package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;

@Deprecated
public class ImageResourceExampleController implements Controller {

    public static final String DEMO_URL = ImageResourceExampleResources.INSTANCE.demo().getSafeUri().asString();
    
    @Override
    public void onControllerLoad() {
    }
}
