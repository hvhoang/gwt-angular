package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.ClientResources;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.TextResource;


public interface CustomFilterExampleResources extends ClientResources {

    static final CustomFilterExampleResources INSTANCE = GWT.create(CustomFilterExampleResources.class);

    static final String DEMO_URL = CustomFilterExampleResources.INSTANCE.demo().getSafeUri().asString();
    
    @Source("CustomFilterExampleDocumentation.html")
    HtmlResource customFilter();

    @Source("CustomFilterExample.html")
    HtmlResource demo();

    // Core Resources

    @Source("com/asayama/gwt/angular/site/examples/CustomFilterExample.gwt.xml")
    TextResource config();

    @Source("CustomFilterExample.java")
    TextResource module();
    
    @Source("CustomFilterExampleController.java")
    TextResource controller();
    
    @Source("CustomFilterExample.html")
    TextResource view();

    // Other Resources
    
    @Source("filter/Reverse.java")
    TextResource filter();
}
