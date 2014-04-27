package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface HttpClientExampleResources extends ClientBundle {

    static HttpClientExampleResources INSTANCE = GWT.create(HttpClientExampleResources.class);

    @Source("view/HttpClientExample.html")
    HtmlResource httpClient();

    @Source("view/HttpClient.html")
    HtmlResource demo();

    @Source("view/HttpClient.html")
    TextResource view();
    
    @Source("HttpClientController.java")
    TextResource controller();
    
    @Source("HttpClientExample.java")
    TextResource module();
    
    @Source("com/asayama/gwt/angular/site/examples/HttpClientExample.gwt.xml")
    TextResource config();
}
