package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface PromiseDemoResources extends ClientBundle {

    static PromiseDemoResources INSTANCE = GWT.create(PromiseDemoResources.class);

    @Source("PromiseDemo.html")
    HtmlResource partial();

    @Source("PromiseDemo.html")
    TextResource view();
    
    @Source("controller/PromiseDemoController.java")
    TextResource controller();
}
