package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface CustomFilterExampleResources extends ClientBundle {

    static final CustomFilterExampleResources INSTANCE = GWT.create(CustomFilterExampleResources.class);

    static final String DEMO_URL = CustomFilterExampleResources.INSTANCE.demo().getSafeUri().asString();
    
    @Source("view/CustomFilterExampleDocumentation.html")
    HtmlResource customFilter();

    @Source("view/CustomFilterExample.html")
    HtmlResource demo();

    // Core Resources

    @Source("com/asayama/gwt/angular/site/examples/CustomFilterExample.gwt.xml")
    TextResource config();

    @Source("CustomFilterExample.java")
    TextResource module();
    
    @Source("CustomFilterExampleController.java")
    TextResource controller();
    
    @Source("view/CustomFilterExample.html")
    TextResource view();

    // Other Resources
    
    @Source("filter/Reverse.java")
    TextResource filter();
}
