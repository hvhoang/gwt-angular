package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Partial;
import com.asayama.gwt.angular.client.Partials;
import com.google.gwt.core.shared.GWT;


public interface ExamplesPartials extends Partials {
    
    public static final ExamplesPartials INSTANCE = GWT.create(ExamplesPartials.class);

    @Source("Examples.html")
    public Partial examples();
    
    @Source("TextInputExample.html")
    public Partial textInput();
    
    @Source("OnClickEventExample.html")
    public Partial onClickEvent();
    
    @Source("ReverseFilterExample.html")
    public Partial reverseFilter();

    @Source("UrlHashParameterExample.html")
    public Partial urlHashParameter();
    
    @Source("HttpClientExample.html")
    public Partial httpClient();

    @Source("PrettifyExample.html")
    public Partial prettify();
}
