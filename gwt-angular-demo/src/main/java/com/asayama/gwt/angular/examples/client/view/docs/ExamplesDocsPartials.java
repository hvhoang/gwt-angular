package com.asayama.gwt.angular.examples.client.view.docs;

import com.asayama.gwt.angular.client.Partial;
import com.asayama.gwt.angular.client.Partials;
import com.google.gwt.core.shared.GWT;


public interface ExamplesDocsPartials extends Partials {
    
    public static final ExamplesDocsPartials INSTANCE = GWT.create(ExamplesDocsPartials.class);

    @Resource("Examples.html")
    public Partial examples();
    
    @Resource("TextInputExample.html")
    public Partial textInput();
    
    @Resource("OnClickEventExample.html")
    public Partial onClickEvent();
    
    @Resource("ReverseFilterExample.html")
    public Partial reverseFilter();
    
    @Resource("CustomDirectiveExample.html")
    public Partial customDirective();

    @Resource("UrlHashParameterExample.html")
    public Partial urlHashParameter();
    
    @Resource("HttpClientExample.html")
    public Partial httpClient();

    @Resource("PrettifyExample.html")
    public Partial prettify();
}
