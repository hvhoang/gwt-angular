package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface CustomDirectiveExampleResources extends ClientBundle {

    static CustomDirectiveExampleResources INSTANCE = GWT.create(CustomDirectiveExampleResources.class);

    @Source("view/CustomDirectiveExample.html")
    HtmlResource customDirective();

    @Source("view/CustomDirective.html")
    HtmlResource demo();

    // Core Resources
    
    @Source("com/asayama/gwt/angular/site/examples/CustomDirectiveExample.gwt.xml")
    TextResource config();

    @Source("CustomDirectiveExample.java")
    TextResource module();
    
    @Source("CustomDirectiveController.java")
    TextResource controller();
    
    @Source("view/CustomDirective.html")
    TextResource view();
    
    // Other Resources

    @Source("directive/MyHello.java")
    TextResource directive();
    
    @Source("directive/MyHello.html")
    TextResource template();
}
