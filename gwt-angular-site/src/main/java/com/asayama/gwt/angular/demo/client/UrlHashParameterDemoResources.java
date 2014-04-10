package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface UrlHashParameterDemoResources extends ClientBundle {

    static UrlHashParameterDemoResources INSTANCE = GWT.create(UrlHashParameterDemoResources.class);

    @Source("view/UrlHashParameterDemo.html")
    HtmlResource partial();

    @Source("view/UrlHashParameterDemo.html")
    TextResource view();
    
    @Source("controller/UrlHashParameterDemoController.java")
    TextResource controller();
}
