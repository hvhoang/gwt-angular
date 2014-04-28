package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface PromiseExampleResources extends ClientBundle {

    static PromiseExampleResources INSTANCE = GWT.create(PromiseExampleResources.class);

    @Source("view/PromiseExample.html")
    HtmlResource promise();

    @Source("view/Promise.html")
    HtmlResource demo();
    
    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/PromiseExample.gwt.xml")
    TextResource config();
    
    @Source("PromiseExample.java")
    TextResource module();
    
    @Source("PromiseController.java")
    TextResource controller();

    @Source("view/Promise.html")
    TextResource view();
    
    // Other Resources
    
    @Source("service/GreetingService.java")
    TextResource service();
}
