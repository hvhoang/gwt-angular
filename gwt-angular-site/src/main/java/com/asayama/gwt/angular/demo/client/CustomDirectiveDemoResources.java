package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface CustomDirectiveDemoResources extends ClientBundle {

    static CustomDirectiveDemoResources INSTANCE = GWT.create(CustomDirectiveDemoResources.class);

    @Source("CustomDirectiveDemo.html")
    HtmlResource partial();
    
    @Source("CustomDirectiveDemo.html")
    TextResource view();

    @Source("CustomeDirectiveModule.txt")
    TextResource module();
    
    @Source("directive/MyHello.java")
    TextResource directive();
    
    @Source("directive/MyHello.html")
    TextResource template();

    @Source("controller/CustomDirectiveDemoController.java")
    TextResource controller();
}
