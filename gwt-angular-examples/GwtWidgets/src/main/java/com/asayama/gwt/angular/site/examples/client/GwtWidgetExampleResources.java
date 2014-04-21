package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface GwtWidgetExampleResources extends ClientBundle {

    static GwtWidgetExampleResources INSTANCE = GWT.create(GwtWidgetExampleResources.class);
    
    @Source("view/GwtWidgetDemo.html")
    HtmlResource demo();

    @Source("view/GwtWidgetDemo.html")
    TextResource view();
    
    @Source("GwtWidgetDemoController.java")
    TextResource controller();
}
