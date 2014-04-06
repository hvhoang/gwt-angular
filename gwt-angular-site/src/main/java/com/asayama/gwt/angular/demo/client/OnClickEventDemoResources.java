package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface OnClickEventDemoResources extends ClientBundle {

    static OnClickEventDemoResources INSTANCE = GWT.create(OnClickEventDemoResources.class);

    @Source("OnClickEventDemo.html")
    HtmlResource partial();

    @Source("OnClickEventDemo.html")
    TextResource view();
    
    @Source("controller/OnClickEventDemoController.java")
    TextResource controller();
}
