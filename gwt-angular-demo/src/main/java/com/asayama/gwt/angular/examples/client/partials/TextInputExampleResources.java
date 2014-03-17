package com.asayama.gwt.angular.examples.client.partials;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;


public interface TextInputExampleResources extends ClientBundle {
    
    static final TextInputExampleResources INSTANCE = GWT.create(TextInputExampleResources.class);

    @DoNotEmbed
    @MimeType("text/html")
    @Source("TextInputExampleDemo.html")
    public DataResource demo();
    
    @Source("TextInputExampleDemo.html")
    public TextResource html();
    
    @Source("com/asayama/gwt/angular/examples/client/TextInputExampleController.java")
    public TextResource java();
}