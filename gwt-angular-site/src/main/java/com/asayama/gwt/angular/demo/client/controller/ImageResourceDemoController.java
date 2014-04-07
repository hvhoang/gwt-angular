package com.asayama.gwt.angular.demo.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public class ImageResourceDemoController implements Controller {

    public static final ImageResource STREET = ImageResourceDemoResources.INSTANCE.street();
    public static final ImageResource WTC = ImageResourceDemoResources.INSTANCE.wtc();
    public static final ImageResource BOAT = ImageResourceDemoResources.INSTANCE.boat();
    public static final ImageResource PEOPLE = ImageResourceDemoResources.INSTANCE.people();
    
    @Override
    public void onControllerLoad() {
        //noop
    }
}

interface ImageResourceDemoResources extends ClientBundle {
    
    static ImageResourceDemoResources INSTANCE = GWT.create(ImageResourceDemoResources.class);
    
    @Source("street.jpg")
    ImageResource street();
    
    @Source("wtc.jpg")
    ImageResource wtc();
    
    @Source("boat.jpg")
    ImageResource boat();
    
    @Source("people.jpg")
    ImageResource people();
}
