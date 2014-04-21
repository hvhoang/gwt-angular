package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface HttpClientExampleResources extends ClientBundle {

    static HttpClientExampleResources INSTANCE = GWT.create(HttpClientExampleResources.class);

    @Source("view/HttpClientDemo.html")
    HtmlResource demo();

    @Source("view/HttpClientDemo.html")
    TextResource view();
    
    @Source("HttpClientDemoController.java")
    TextResource controller();
}
