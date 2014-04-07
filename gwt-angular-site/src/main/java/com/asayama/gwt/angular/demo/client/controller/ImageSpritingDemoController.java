package com.asayama.gwt.angular.demo.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public class ImageSpritingDemoController implements Controller {

    public static final ImageResource STREET = ImageSpritingDemoResources.INSTANCE.street();
    public static final ImageResource WTC = ImageSpritingDemoResources.INSTANCE.wtc();
    public static final ImageResource BOAT = ImageSpritingDemoResources.INSTANCE.boat();
    
    @Override
    public void onControllerLoad() {
        //noop
    }
}

interface ImageSpritingDemoResources extends ClientBundle {
    
    static ImageSpritingDemoResources INSTANCE = GWT.create(ImageSpritingDemoResources.class);
    
    @Source("com/asayama/gwt/angular/demo/client/C41-00005-17.jpg")
    ImageResource street();
    
    @Source("com/asayama/gwt/angular/demo/client/C41-00006-09.jpg")
    ImageResource wtc();
    
    @Source("com/asayama/gwt/angular/demo/client/C41-00009-03.jpg")
    ImageResource boat();
}
