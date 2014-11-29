package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.ClientResources;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.TextResource;


public interface UrlHashParameterExampleResources extends ClientResources {

    static final UrlHashParameterExampleResources INSTANCE = GWT.create(UrlHashParameterExampleResources.class);

    static final String DEMO_URL = UrlHashParameterExampleResources.INSTANCE.demo().getSafeUri().asString();
    
    @Source("view/UrlHashParameterExampleDocumentation.html")
    HtmlResource urlHashParameter();

    @Source("view/UrlHashParameterExample.html")
    HtmlResource demo();
    
    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/UrlHashParameterExample.gwt.xml")
    TextResource config();
    
    @Source("UrlHashParameterExample.java")
    TextResource module();
    
    @Source("UrlHashParameterExampleController.java")
    TextResource controller();

    @Source("view/UrlHashParameterExample.html")
    TextResource view();
}
