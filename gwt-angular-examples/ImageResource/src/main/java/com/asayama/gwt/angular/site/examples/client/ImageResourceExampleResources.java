package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface ImageResourceExampleResources extends ClientBundle {
    
    static ImageResourceExampleResources INSTANCE = GWT.create(ImageResourceExampleResources.class);

    @Source("view/ImageResourceDemo.html")
    HtmlResource demo();

    @Source("view/ImageResourceDemo.html")
    TextResource view();

    @Source("ImageResourceDemoController.java")
    TextResource controller();
}
