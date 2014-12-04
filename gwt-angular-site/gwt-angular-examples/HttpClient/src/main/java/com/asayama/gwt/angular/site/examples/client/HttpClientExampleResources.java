package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.ClientResources;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.TextResource;


public interface HttpClientExampleResources extends ClientResources {

    static final HttpClientExampleResources INSTANCE = GWT.create(HttpClientExampleResources.class);

    static final String DEMO_URL = HttpClientExampleResources.INSTANCE.demo().getSafeUri().asString();

    @Source("HttpClientExampleDocumentation.html")
    HtmlResource httpClient();

    @Source("HttpClientExample.html")
    HtmlResource demo();
    
    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/HttpClientExample.gwt.xml")
    TextResource config();
    
    @Source("HttpClientExample.java")
    TextResource module();
    
    @Source("HttpClientExampleController.java")
    TextResource controller();

    @Source("HttpClientExample.html")
    TextResource view();
}
