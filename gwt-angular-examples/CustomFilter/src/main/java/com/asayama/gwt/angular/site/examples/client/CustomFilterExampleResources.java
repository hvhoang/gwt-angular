package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface CustomFilterExampleResources extends ClientBundle {

    static CustomFilterExampleResources INSTANCE = GWT.create(CustomFilterExampleResources.class);

    @Source("view/CustomFilterExample.html")
    HtmlResource customDirective();

    @Source("view/CustomFilterDemo.html")
    HtmlResource demo();

    @Source("view/CustomFilterDemo.html")
    TextResource view();
    
    @Source("ReverseFilterDemoController.java")
    TextResource controller();

    @Source("filter/Reverse.java")
    TextResource filter();

    @Source("view/CustomFilterModule.txt")
    TextResource module();
}
