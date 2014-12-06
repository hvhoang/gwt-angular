package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.ClientResources;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.TextResource;


public interface PromiseExampleResources extends ClientResources {

    static final PromiseExampleResources INSTANCE = GWT.create(PromiseExampleResources.class);

    static final String DEMO_URL = PromiseExampleResources.INSTANCE.demo().getSafeUri().asString();
    
    @Source("PromiseExampleDocumentation.html")
    HtmlResource promise();

    @Source("PromiseExample.html")
    HtmlResource demo();
    
    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/PromiseExample.gwt.xml")
    TextResource config();
    
    @Source("PromiseExample.java")
    TextResource module();
    
    @Source("PromiseExampleController.java")
    TextResource controller();

    @Source("PromiseExample.html")
    TextResource view();
    
    // Other Resources
    
    @Source("service/GreetingService.java")
    TextResource service();
}
