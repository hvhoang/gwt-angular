package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface UrlHashParameterExampleResources extends ClientBundle {

    static UrlHashParameterExampleResources INSTANCE = GWT.create(UrlHashParameterExampleResources.class);

    @Source("view/UrlHashParameterDemo.html")
    HtmlResource demo();

    @Source("view/UrlHashParameterDemo.html")
    TextResource view();
    
    @Source("UrlHashParameterDemoController.java")
    TextResource controller();
}
