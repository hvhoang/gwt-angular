package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.ImageResourceDemoResources;
import com.asayama.gwt.angular.demo.client.ImageResourceDemoController.ImageResources;
import com.google.gwt.resources.client.TextResource;


public class ImageResourceExampleController implements Controller {

    public static final String DEMO_URL = ImageResourceDemoResources.INSTANCE.partial().getSafeUri().asString();
    public static final TextResource VIEW_CODE = ImageResourceDemoResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = ImageResourceDemoResources.INSTANCE.controller();

    public static final String STREET_URL = ImageResources.INSTANCE.street().getSafeUri().asString();
    public static final String WTC_URL = ImageResources.INSTANCE.wtc().getSafeUri().asString();
    public static final String BOAT_URL = ImageResources.INSTANCE.boat().getSafeUri().asString();
    public static final String PEOPLE_URL = ImageResources.INSTANCE.people().getSafeUri().asString();
    
    @Override
    public void onControllerLoad() {
    }
}
