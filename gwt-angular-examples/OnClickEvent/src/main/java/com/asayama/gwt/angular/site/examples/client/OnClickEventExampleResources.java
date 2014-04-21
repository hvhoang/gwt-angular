package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface OnClickEventExampleResources extends ClientBundle {

    static OnClickEventExampleResources INSTANCE = GWT.create(OnClickEventExampleResources.class);

    @Source("view/OnClickEventExample.html")
    HtmlResource onClickEvent();

    @Source("view/OnClickEventDemo.html")
    HtmlResource demo();

    @Source("view/OnClickEventDemo.html")
    TextResource view();
    
    @Source("OnClickEventDemoController.java")
    TextResource controller();
}
