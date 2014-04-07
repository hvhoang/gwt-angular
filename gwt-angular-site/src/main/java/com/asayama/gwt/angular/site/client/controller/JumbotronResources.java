package com.asayama.gwt.angular.site.client.controller;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;


public interface JumbotronResources extends ClientBundle {
    
    static JumbotronResources INSTANCE = GWT.create(JumbotronResources.class);

    @Source("mvc.png")
    ImageResource mvc();
}
