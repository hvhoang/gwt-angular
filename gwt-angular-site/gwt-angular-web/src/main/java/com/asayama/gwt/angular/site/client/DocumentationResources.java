package com.asayama.gwt.angular.site.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;


public interface DocumentationResources extends ClientBundle {
    
    static DocumentationResources INSTANCE = GWT.create(DocumentationResources.class);

    @Source("view/mvc.png")
    ImageResource mvc();
}
