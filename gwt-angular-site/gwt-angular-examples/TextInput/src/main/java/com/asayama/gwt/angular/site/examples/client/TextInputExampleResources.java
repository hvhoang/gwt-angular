package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.ClientResources;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.TextResource;


public interface TextInputExampleResources extends ClientResources {

    static final TextInputExampleResources INSTANCE = GWT.create(TextInputExampleResources.class);
    
    static final String DEMO_URL = TextInputExampleResources.INSTANCE.demo().getSafeUri().asString();

    @Source("TextInputExampleDocumentation.html")
    HtmlResource textInput();

    @Source("TextInputExample.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/TextInputExample.gwt.xml")
    TextResource config();

    @Source("TextInputExample.java")
    TextResource module();
    
    @Source("TextInputExampleController.java")
    TextResource controller();
    
    @Source("TextInputExample.html")
    TextResource view();
}
