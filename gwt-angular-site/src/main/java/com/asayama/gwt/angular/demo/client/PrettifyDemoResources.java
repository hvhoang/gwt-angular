package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface PrettifyDemoResources extends ClientBundle {

    static PrettifyDemoResources INSTANCE = GWT.create(PrettifyDemoResources.class);

    @Source("PrettifyDemo.html")
    HtmlResource partial();

    @Source("PrettifyDemo.html")
    TextResource view();
    
    @Source("controller/PrettifyDemoController.java")
    TextResource controller();
}
