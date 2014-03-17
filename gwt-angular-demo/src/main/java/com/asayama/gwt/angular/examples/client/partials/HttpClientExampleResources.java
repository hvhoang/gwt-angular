package com.asayama.gwt.angular.examples.client.partials;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;


public interface HttpClientExampleResources extends ClientBundle {

    static final HttpClientExampleResources INSTANCE = GWT.create(HttpClientExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("HttpClientExampleDemo.html")
    public DataResource demo();

    @Source("HttpClientExampleDemo.html")
    public TextResource html();
    
    @Source("com/asayama/gwt/angular/examples/client/HttpClientExampleController.java")
    public TextResource java();
}
