package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface TextInputDemoResources extends ClientBundle {

    static TextInputDemoResources INSTANCE = GWT.create(TextInputDemoResources.class);
    
    @Source("TextInputDemo.html")
    HtmlResource textInput();

    @Source("TextInputDemo.html")
    TextResource view();
    
    @Source("controller/TextInputDemoController.java")
    TextResource controller();
}
