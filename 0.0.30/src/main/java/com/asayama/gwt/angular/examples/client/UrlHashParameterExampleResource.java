package com.asayama.gwt.angular.examples.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface UrlHashParameterExampleResource extends ClientBundle {

    static final UrlHashParameterExampleResource INSTANCE = GWT.create(UrlHashParameterExampleResource.class);
    
    @Source("UrlHashParameterExample.html")
    public TextResource html();
    
    @Source("UrlHashParameterExampleController.java")
    public TextResource java();
}
