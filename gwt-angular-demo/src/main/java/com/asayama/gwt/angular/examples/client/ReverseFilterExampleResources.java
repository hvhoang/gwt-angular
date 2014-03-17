package com.asayama.gwt.angular.examples.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;


public interface ReverseFilterExampleResources extends ClientBundle {

    static final ReverseFilterExampleResources INSTANCE = GWT.create(ReverseFilterExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("ReverseFilterExampleDemo.html")
    public DataResource demo();

    @Source("ReverseFilterExampleDemo.html")
    public TextResource html();
    
    @Source("ReverseFilterExampleController.java")
    public TextResource java();
}
