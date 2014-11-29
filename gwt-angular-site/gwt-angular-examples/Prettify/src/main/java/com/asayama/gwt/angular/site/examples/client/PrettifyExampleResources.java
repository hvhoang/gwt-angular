package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.ClientResources;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.TextResource;


public interface PrettifyExampleResources extends ClientResources {

    static final PrettifyExampleResources INSTANCE = GWT.create(PrettifyExampleResources.class);

    static final String DEMO_URL = PrettifyExampleResources.INSTANCE.demo().getSafeUri().asString();
    
   @Source("view/PrettifyExampleDocumentation.html")
    HtmlResource prettify();

    @Source("view/PrettifyExample.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/PrettifyExample.gwt.xml")
    TextResource config();
    
    @Source("PrettifyExample.java")
    TextResource module();
    
    @Source("PrettifyExampleController.java")
    TextResource controller();
    
    @Source("view/PrettifyExample.html")
    TextResource view();
}
