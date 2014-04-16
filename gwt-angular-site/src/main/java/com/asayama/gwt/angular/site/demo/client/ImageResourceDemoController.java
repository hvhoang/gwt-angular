package com.asayama.gwt.angular.site.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public class ImageResourceDemoController implements Controller {

    public static final ImageResource STREET = ImageResources.INSTANCE.street();
    public static final ImageResource WTC = ImageResources.INSTANCE.wtc();
    public static final ImageResource BOAT = ImageResources.INSTANCE.boat();
    public static final ImageResource PEOPLE = ImageResources.INSTANCE.people();
    
    @Override
    public void onControllerLoad() {
        //noop
    }

    public static interface ImageResources extends ClientBundle {
        
        static ImageResources INSTANCE = GWT.create(ImageResources.class);
        
        @Source("view/street.jpg")
        ImageResource street();
        
        @Source("view/wtc.jpg")
        ImageResource wtc();
        
        @Source("view/boat.jpg")
        ImageResource boat();
        
        @Source("view/people.jpg")
        ImageResource people();
    }
}
