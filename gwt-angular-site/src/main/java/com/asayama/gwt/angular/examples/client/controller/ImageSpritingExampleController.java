package com.asayama.gwt.angular.examples.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.demo.client.ImageSpritingDemoResources;
import com.google.gwt.resources.client.TextResource;


public class ImageSpritingExampleController implements Controller {

    public static final String DEMO_URL = ImageSpritingDemoResources.INSTANCE.imageSpriting().getSafeUri().asString();
    public static final TextResource VIEW_CODE = ImageSpritingDemoResources.INSTANCE.view();
    public static final TextResource CONTROLLER_CODE = ImageSpritingDemoResources.INSTANCE.controller();

    @Override
    public void onControllerLoad() {
    }
}
