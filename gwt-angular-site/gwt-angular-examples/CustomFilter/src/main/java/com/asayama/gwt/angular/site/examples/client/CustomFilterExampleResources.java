package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface CustomFilterExampleResources extends ClientBundle {

    static CustomFilterExampleResources INSTANCE = GWT.create(CustomFilterExampleResources.class);

    @Source("view/CustomFilterExample.html")
    HtmlResource customFilter();

    @Source("view/CustomFilter.html")
    HtmlResource demo();

    @Source("view/CustomFilter.html")
    TextResource view();
    
    @Source("CustomFilterController.java")
    TextResource controller();

    @Source("filter/Reverse.java")
    TextResource filter();

    @Source("CustomFilterExample.java")
    TextResource module();
}
