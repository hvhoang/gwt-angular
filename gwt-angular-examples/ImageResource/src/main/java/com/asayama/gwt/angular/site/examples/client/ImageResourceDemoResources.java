package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface ImageResourceDemoResources extends ClientBundle {
    
    static ImageResourceDemoResources INSTANCE = GWT.create(ImageResourceDemoResources.class);

    @Source("view/ImageResourceDemo.html")
    HtmlResource demo();

    @Source("view/ImageResourceDemo.html")
    TextResource view();

    @Source("ImageResourceDemoController.java")
    TextResource controller();
}
