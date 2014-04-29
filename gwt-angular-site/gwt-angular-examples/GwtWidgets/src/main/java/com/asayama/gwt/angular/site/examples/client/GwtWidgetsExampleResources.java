package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface GwtWidgetsExampleResources extends ClientBundle {

    static final GwtWidgetsExampleResources INSTANCE = GWT.create(GwtWidgetsExampleResources.class);
    
    static final String DEMO_URL = GwtWidgetsExampleResources.INSTANCE.demo().getSafeUri().asString();
    
    @Source("view/GwtWidgetsExample.html")
    HtmlResource gwtWidgets();

    @Source("view/GwtWidgets.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/GwtWidgetsExample.gwt.xml")
    TextResource config();
    
    @Source("GwtWidgetsExample.java")
    TextResource module();
    
    @Source("GwtWidgetsExampleController.java")
    TextResource controller();
    
    @Source("view/GwtWidgets.html")
    TextResource view();
}
