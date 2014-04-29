package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface TextInputExampleResources extends ClientBundle {

    static final TextInputExampleResources INSTANCE = GWT.create(TextInputExampleResources.class);
    
    static final String DEMO_URL = TextInputExampleResources.INSTANCE.demo().getSafeUri().asString();

    @Source("view/TextInputExampleDocumentation.html")
    HtmlResource textInput();

    @Source("view/TextInputExample.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/TextInputExample.gwt.xml")
    TextResource config();

    @Source("TextInputExample.java")
    TextResource module();
    
    @Source("TextInputExampleController.java")
    TextResource controller();
    
    @Source("view/TextInputExample.html")
    TextResource view();
}
