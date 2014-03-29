package com.asayama.gwt.angular.examples.client.view;

import com.asayama.gwt.angular.client.Partial;
import com.asayama.gwt.angular.client.Partials;
import com.google.gwt.core.shared.GWT;


public interface ExamplesPartials extends Partials {
    
    public static final ExamplesPartials INSTANCE = GWT.create(ExamplesPartials.class);

    @Resource("Examples.html")
    public Partial examples();
    
    @Resource("TextInputExample.html")
    public Partial textInput();
    
    @Resource("OnClickEventExample.html")
    public Partial onClickEvent();
    
    @Resource("ReverseFilterExample.html")
    public Partial reverseFilter();

    @Resource("UrlHashParameterExample.html")
    public Partial urlHashParameter();
    
    @Resource("HttpClientExample.html")
    public Partial httpClient();

    @Resource("PrettifyExample.html")
    public Partial prettify();
}
