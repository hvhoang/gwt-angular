package com.asayama.gwt.angular.examples.client.view.demo;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;


public interface ExamplesDemoResources extends ClientBundle {

    static final ExamplesDemoResources INSTANCE = GWT.create(ExamplesDemoResources.class);
    
    @Source("CustomDirectiveExample.html")
    HtmlResource customDirectiveExample();
    
    @Source("HttpClientExample.html")
    HtmlResource httpClient();

    @Source("OnClickEventExample.html")
    HtmlResource onClickEvent();

    @Source("PrettifyExample.html")
    HtmlResource prettify();

    @Source("ReverseFilterExample.html")
    HtmlResource reverseFilter();

    @Source("TextInputExample.html")
    HtmlResource textInput();

    @Source("UrlHashParameterExample.html")
    HtmlResource urlHashParameter();
}
