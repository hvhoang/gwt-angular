package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface PromiseExampleResources extends ClientBundle {

    static PromiseExampleResources INSTANCE = GWT.create(PromiseExampleResources.class);

    @Source("view/PromiseDemo.html")
    HtmlResource demo();

    @Source("view/PromiseDemo.html")
    TextResource view();
    
    @Source("PromiseDemoController.java")
    TextResource controller();
    
    @Source("service/GreetingService.java")
    TextResource service();
}
