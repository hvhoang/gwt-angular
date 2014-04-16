package com.asayama.gwt.angular.site.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface CustomFilterDemoResources extends ClientBundle {

    static CustomFilterDemoResources INSTANCE = GWT.create(CustomFilterDemoResources.class);

    @Source("view/CustomFilterDemo.html")
    HtmlResource partial();

    @Source("view/CustomFilterDemo.html")
    TextResource view();
    
    @Source("ReverseFilterDemoController.java")
    TextResource controller();

    @Source("filter/Reverse.java")
    TextResource filter();

    @Source("view/CustomFilterModule.txt")
    TextResource module();
}
