package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.ClientResources;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.TextResource;


public interface OnClickEventExampleResources extends ClientResources {

    static final OnClickEventExampleResources INSTANCE = GWT.create(OnClickEventExampleResources.class);

    static final String DEMO_URL = OnClickEventExampleResources.INSTANCE.demo().getSafeUri().asString();

   @Source("OnClickEventExampleDocumentation.html")
    HtmlResource onClickEvent();

    @Source("OnClickEventExample.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/OnClickEventExample.gwt.xml")
    TextResource config();
    
    @Source("OnClickEventExample.java")
    TextResource module();
    
    @Source("OnClickEventExampleController.java")
    TextResource controller();
    
    @Source("OnClickEventExample.html")
    TextResource view();
}
