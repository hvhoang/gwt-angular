package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface TextInputDemoResources extends ClientBundle {

    static TextInputDemoResources INSTANCE = GWT.create(TextInputDemoResources.class);
    
    @Source("view/TextInputDemo.html")
    HtmlResource demo();

    @Source("view/TextInputDemo.html")
    TextResource view();
    
    @Source("TextInputDemoController.java")
    TextResource controller();
}
