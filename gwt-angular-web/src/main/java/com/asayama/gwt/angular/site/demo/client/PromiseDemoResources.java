package com.asayama.gwt.angular.site.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface PromiseDemoResources extends ClientBundle {

    static PromiseDemoResources INSTANCE = GWT.create(PromiseDemoResources.class);

    @Source("view/PromiseDemo.html")
    HtmlResource partial();

    @Source("view/PromiseDemo.html")
    TextResource view();
    
    @Source("PromiseDemoController.java")
    TextResource controller();
    
    @Source("service/GreetingService.java")
    TextResource service();
}
