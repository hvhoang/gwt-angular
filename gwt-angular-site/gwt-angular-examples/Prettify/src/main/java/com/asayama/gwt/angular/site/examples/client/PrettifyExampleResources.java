package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface PrettifyExampleResources extends ClientBundle {

    static PrettifyExampleResources INSTANCE = GWT.create(PrettifyExampleResources.class);

    @Source("view/PrettifyExample.html")
    HtmlResource prettify();

    @Source("view/Prettify.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/PrettifyExample.gwt.xml")
    TextResource config();
    
    @Source("PrettifyExample.java")
    TextResource module();
    
    @Source("PrettifyController.java")
    TextResource controller();
    
    @Source("view/Prettify.html")
    TextResource view();
}
