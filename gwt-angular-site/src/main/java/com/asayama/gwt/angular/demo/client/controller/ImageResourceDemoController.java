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
    
    @Source("com/asayama/gwt/angular/demo/client/C41-00005-17.jpg")
    ImageResource street();
    
    @Source("com/asayama/gwt/angular/demo/client/C41-00006-09.jpg")
    ImageResource wtc();
    
    @Source("com/asayama/gwt/angular/demo/client/C41-00009-03.jpg")
    ImageResource boat();
    
    @Source("com/asayama/gwt/angular/demo/client/E6-00020-29.jpg")
    ImageResource people();
}
