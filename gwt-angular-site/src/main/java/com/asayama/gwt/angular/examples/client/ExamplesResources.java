package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;


public interface ExamplesResources extends ClientBundle {
    
    public static final ExamplesResources INSTANCE = GWT.create(ExamplesResources.class);
    
    @Source("CustomFilterExample.html")
    public HtmlResource customFilter();
    
    @Source("CustomDirectiveExample.html")
    public HtmlResource customDirective();
    
    @Source("HttpClientExample.html")
    public HtmlResource httpClient();

    @Source("ImageResourceExample.html")
    public HtmlResource imageResource();
    
    @Source("OnClickEventExample.html")
    public HtmlResource onClickEvent();
    
    @Source("PrettifyExample.html")
    public HtmlResource prettify();
    
    @Source("TextInputExample.html")
    public HtmlResource textInput();

    @Source("UrlHashParameterExample.html")
    public HtmlResource urlHashParameter();
}
