package com.asayama.gwt.angular.demo.client.view;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;


public interface DemoResources extends ClientBundle {

    public static final DemoResources INSTANCE = GWT.create(DemoResources.class);
    
    @Source("mvc.png")
    ImageResource mvc();
}
