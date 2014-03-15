package com.asayama.gwt.angular.examples.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public 
interface TextInputExampleResource extends ClientBundle {
    
    static final TextInputExampleResource INSTANCE = GWT.create(TextInputExampleResource.class);
    
    @Source("TextInputExample.html")
    public TextResource html();
    
    @Source("TextInputExampleController.java")
    public TextResource java();
}