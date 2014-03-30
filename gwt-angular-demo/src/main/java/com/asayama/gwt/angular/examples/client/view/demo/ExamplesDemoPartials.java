package com.asayama.gwt.angular.examples.client.view.demo;

import com.asayama.gwt.angular.client.Partial;
import com.asayama.gwt.angular.client.Partials;
import com.google.gwt.core.shared.GWT;


public interface ExamplesDemoPartials extends Partials {

    static final ExamplesDemoPartials INSTANCE = GWT.create(ExamplesDemoPartials.class);
    
    @Resource("HttpClientExample.html")
    Partial httpClient();

    @Resource("OnClickEventExample.html")
    Partial onClickEvent();

    @Resource("PrettifyExample.html")
    Partial prettify();

    @Resource("ReverseFilterExample.html")
    Partial reverseFilter();

    @Resource("TextInputExample.html")
    Partial textInput();

    @Resource("UrlHashParameterExample.html")
    Partial urlHashParameter();
    
}
