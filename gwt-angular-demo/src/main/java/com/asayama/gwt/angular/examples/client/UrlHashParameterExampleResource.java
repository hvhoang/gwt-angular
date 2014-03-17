package com.asayama.gwt.angular.examples.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;


public interface UrlHashParameterExampleResource extends ClientBundle {

    static final UrlHashParameterExampleResource INSTANCE = GWT.create(UrlHashParameterExampleResource.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("UrlHashParameterExampleDemo.html")
    public DataResource demo();

    @Source("UrlHashParameterExampleDemo.html")
    public TextResource html();
    
    @Source("UrlHashParameterExampleController.java")
    public TextResource java();
}
