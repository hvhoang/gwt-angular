package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.ClientResources;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.TextResource;


public interface CustomDirectiveExampleResources extends ClientResources {

    static final CustomDirectiveExampleResources INSTANCE = GWT.create(CustomDirectiveExampleResources.class);

    static final String DEMO_URL = CustomDirectiveExampleResources.INSTANCE.demo().getSafeUri().asString();

    @Source("CustomDirectiveExampleDocumentation.html")
    HtmlResource customDirective();

    @Source("CustomDirectiveExample.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/CustomDirectiveExample.gwt.xml")
    TextResource config();

    @Source("CustomDirectiveExample.java")
    TextResource module();
    
    @Source("CustomDirectiveExampleController.java")
    TextResource controller();
    
    @Source("CustomDirectiveExample.html")
    TextResource view();
    
    // Other Resources

    @Source("directive/MyHello.java")
    TextResource directive();
    
    @Source("directive/MyHello.html")
    TextResource template();
}
