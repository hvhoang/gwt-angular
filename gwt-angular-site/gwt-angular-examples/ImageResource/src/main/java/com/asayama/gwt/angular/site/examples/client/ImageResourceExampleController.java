package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.site.examples.client.ImageResourceController.ImageResources;
import com.google.gwt.resources.client.TextResource;


public class ImageResourceExampleController implements Controller {

    public static final String DEMO_URL = ImageResourceExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final TextResource VIEW_CODE = ImageResourceExampleResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = ImageResourceExampleResources.INSTANCE.controller();
    public static final TextResource CONFIG_CODE = ImageResourceExampleResources.INSTANCE.config();

    public static final String STREET_URL = ImageResources.INSTANCE.street().getSafeUri().asString();
    public static final String WTC_URL = ImageResources.INSTANCE.wtc().getSafeUri().asString();
    public static final String BOAT_URL = ImageResources.INSTANCE.boat().getSafeUri().asString();
    public static final String PEOPLE_URL = ImageResources.INSTANCE.people().getSafeUri().asString();
    
    @Override
    public void onControllerLoad() {
    }
}
