package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface HttpClientDemoResources extends ClientBundle {

    static HttpClientDemoResources INSTANCE = GWT.create(HttpClientDemoResources.class);

    @Source("HttpClientDemo.html")
    HtmlResource partial();

    @Source("HttpClientDemo.html")
    TextResource view();
    
    @Source("controller/HttpClientDemoController.java")
    TextResource controller();
}
