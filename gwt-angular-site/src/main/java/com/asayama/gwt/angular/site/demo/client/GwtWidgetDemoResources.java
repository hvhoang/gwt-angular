package com.asayama.gwt.angular.site.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface GwtWidgetDemoResources extends ClientBundle {

    static GwtWidgetDemoResources INSTANCE = GWT.create(GwtWidgetDemoResources.class);
    
    @Source("view/GwtWidgetDemo.html")
    HtmlResource partial();

    @Source("view/GwtWidgetDemo.html")
    TextResource view();
    
    @Source("GwtWidgetDemoController.java")
    TextResource controller();
}
