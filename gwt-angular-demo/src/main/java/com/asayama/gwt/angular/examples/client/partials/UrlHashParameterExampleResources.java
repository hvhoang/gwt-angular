package com.asayama.gwt.angular.examples.client.partials;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;


public interface UrlHashParameterExampleResources extends ClientBundle {

    static final UrlHashParameterExampleResources INSTANCE = GWT.create(UrlHashParameterExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("UrlHashParameterExampleDemo.html")
    public DataResource demo();

    @Source("UrlHashParameterExampleDemo.html")
    public TextResource html();
    
    @Source("com/asayama/gwt/angular/examples/client/UrlHashParameterExampleController.java")
    public TextResource java();
}
