package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface OnClickEventDemoResources extends ClientBundle {

    static OnClickEventDemoResources INSTANCE = GWT.create(OnClickEventDemoResources.class);

    @Source("view/OnClickEventDemo.html")
    HtmlResource partial();

    @Source("view/OnClickEventDemo.html")
    TextResource view();
    
    @Source("OnClickEventDemoController.java")
    TextResource controller();
}
