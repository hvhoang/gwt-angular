package com.asayama.gwt.angular.site.examples.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ImageResources extends ClientBundle {
    
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

