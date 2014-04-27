package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface GwtWidgetsExampleResources extends ClientBundle {

    static GwtWidgetsExampleResources INSTANCE = GWT.create(GwtWidgetsExampleResources.class);
    
    @Source("view/GwtWidgetsExample.html")
    HtmlResource gwtWidgets();

    @Source("view/GwtWidgets.html")
    HtmlResource demo();

    @Source("view/GwtWidgets.html")
    TextResource view();
    
    @Source("GwtWidgetsController.java")
    TextResource controller();
}
