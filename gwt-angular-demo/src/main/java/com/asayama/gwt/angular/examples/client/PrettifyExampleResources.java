package com.asayama.gwt.angular.examples.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;


public interface PrettifyExampleResources extends ClientBundle {

    static final PrettifyExampleResources INSTANCE = GWT.create(PrettifyExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("PrettifyExampleDemo.html")
    public DataResource demo();

    @Source("PrettifyExampleDemo.html")
    public TextResource html();
    
    @Source("PrettifyExampleController.java")
    public TextResource java();
    
    @Source("PrettifyExampleResources.java")
    public TextResource resources();
}
