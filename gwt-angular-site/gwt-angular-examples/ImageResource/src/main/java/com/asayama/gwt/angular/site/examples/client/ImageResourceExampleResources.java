package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface ImageResourceExampleResources extends ClientBundle {
    
    static ImageResourceExampleResources INSTANCE = GWT.create(ImageResourceExampleResources.class);

    @Source("view/ImageResourceExample.html")
    HtmlResource imageResource();

    @Source("view/ImageResource.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/ImageResourceExample.gwt.xml")
    TextResource config();
    
    @Source("ImageResourceExample.java")
    TextResource module();

    @Source("ImageResourceController.java")
    TextResource controller();
    
    @Source("view/ImageResource.html")
    TextResource view();
}
