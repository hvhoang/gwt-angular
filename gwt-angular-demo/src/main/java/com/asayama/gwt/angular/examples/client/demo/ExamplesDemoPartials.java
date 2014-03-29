package com.asayama.gwt.angular.examples.client.demo;

import com.asayama.gwt.angular.client.Partial;
import com.asayama.gwt.angular.client.Partials;
import com.google.gwt.core.shared.GWT;


public interface ExamplesDemoPartials extends Partials {

    static final ExamplesDemoPartials INSTANCE = GWT.create(ExamplesDemoPartials.class);
    
    @Resource("HttpClientDemo.html")
    Partial httpClient();

    @Resource("OnClickEventDemo.html")
    Partial onClickEvent();

    @Resource("PrettifyDemo.html")
    Partial prettify();

    @Resource("ReverseFilterDemo.html")
    Partial reverseFilter();

    @Resource("TextInputDemo.html")
    Partial textInput();

    @Resource("UrlHashParameterDemo.html")
    Partial urlHashParameter();
    
}
