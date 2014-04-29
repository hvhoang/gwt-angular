package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface HttpClientExampleResources extends ClientBundle {

    static final HttpClientExampleResources INSTANCE = GWT.create(HttpClientExampleResources.class);

    static final String DEMO_URL = HttpClientExampleResources.INSTANCE.demo().getSafeUri().asString();

    @Source("view/HttpClientExample.html")
    HtmlResource httpClient();

    @Source("view/HttpClient.html")
    HtmlResource demo();
    
    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/HttpClientExample.gwt.xml")
    TextResource config();
    
    @Source("HttpClientExample.java")
    TextResource module();
    
    @Source("HttpClientExampleController.java")
    TextResource controller();

    @Source("view/HttpClient.html")
    TextResource view();
}
