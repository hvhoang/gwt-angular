package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface OnClickEventExampleResources extends ClientBundle {

    static final OnClickEventExampleResources INSTANCE = GWT.create(OnClickEventExampleResources.class);

    static final String DEMO_URL = OnClickEventExampleResources.INSTANCE.demo().getSafeUri().asString();

   @Source("view/OnClickEventExampleDocumentation.html")
    HtmlResource onClickEvent();

    @Source("view/OnClickEventExample.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/OnClickEventExample.gwt.xml")
    TextResource config();
    
    @Source("OnClickEventExample.java")
    TextResource module();
    
    @Source("OnClickEventExampleController.java")
    TextResource controller();
    
    @Source("view/OnClickEventExample.html")
    TextResource view();
}
