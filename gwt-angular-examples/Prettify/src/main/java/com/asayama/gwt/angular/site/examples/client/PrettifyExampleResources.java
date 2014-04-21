package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface PrettifyExampleResources extends ClientBundle {

    static PrettifyExampleResources INSTANCE = GWT.create(PrettifyExampleResources.class);

    @Source("view/PrettifyDemo.html")
    HtmlResource demo();

    @Source("view/PrettifyDemo.html")
    TextResource view();
    
    @Source("PrettifyDemoController.java")
    TextResource controller();
}
