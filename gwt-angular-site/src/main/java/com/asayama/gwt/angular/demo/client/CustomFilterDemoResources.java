package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface CustomFilterDemoResources extends ClientBundle {

    static CustomFilterDemoResources INSTANCE = GWT.create(CustomFilterDemoResources.class);

    @Source("CustomFilterDemo.html")
    HtmlResource partial();

    @Source("CustomFilterDemo.html")
    TextResource view();
    
    @Source("controller/ReverseFilterDemoController.java")
    TextResource controller();

    @Source("filter/Reverse.java")
    TextResource filter();

    @Source("CustomFilterModule.txt")
    TextResource module();
}
