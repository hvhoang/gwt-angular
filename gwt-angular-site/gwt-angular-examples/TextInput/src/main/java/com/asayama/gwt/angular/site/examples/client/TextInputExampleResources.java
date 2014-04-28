package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface TextInputExampleResources extends ClientBundle {

    static TextInputExampleResources INSTANCE = GWT.create(TextInputExampleResources.class);
    
    @Source("view/TextInputExample.html")
    HtmlResource textInput();

    @Source("view/TextInput.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/TextInputExample.gwt.xml")
    TextResource config();

    @Source("TextInputExample.java")
    TextResource module();
    
    @Source("TextInputController.java")
    TextResource controller();
    
    @Source("view/TextInput.html")
    TextResource view();
}
