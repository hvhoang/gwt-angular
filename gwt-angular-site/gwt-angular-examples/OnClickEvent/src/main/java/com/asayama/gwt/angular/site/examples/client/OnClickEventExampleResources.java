package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface OnClickEventExampleResources extends ClientBundle {

    static OnClickEventExampleResources INSTANCE = GWT.create(OnClickEventExampleResources.class);

    @Source("view/OnClickEventExample.html")
    HtmlResource onClickEvent();

    @Source("view/OnClickEvent.html")
    HtmlResource demo();

    @Source("view/OnClickEvent.html")
    TextResource view();
    
    @Source("OnClickEventController.java")
    TextResource controller();
    
    @Source("OnClickEventExample.java")
    TextResource module();
    
    @Source("com/asayama/gwt/angular/site/examples/OnClickEventExample.gwt.xml")
    TextResource config();
}
