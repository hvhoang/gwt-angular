package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface ImageSpritingDemoResources extends ClientBundle {
    
    static ImageSpritingDemoResources INSTANCE = GWT.create(ImageSpritingDemoResources.class);

    @Source("ImageSpritingDemo.html")
    HtmlResource imageSpriting();

    @Source("ImageSpritingDemo.html")
    TextResource view();

    @Source("controller/ImageSpritingDemoController.java")
    TextResource controller();
}
