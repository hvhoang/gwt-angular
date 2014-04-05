package com.asayama.gwt.angular.examples.client.view.docs;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;


public interface ExamplesDocsResources extends ClientBundle {
    
    public static final ExamplesDocsResources INSTANCE = GWT.create(ExamplesDocsResources.class);

    @Source("Examples.html")
    public HtmlResource examples();
    
    @Source("TextInputExample.html")
    public HtmlResource textInput();
    
    @Source("OnClickEventExample.html")
    public HtmlResource onClickEvent();
    
    @Source("ReverseFilterExample.html")
    public HtmlResource reverseFilter();
    
    @Source("CustomDirectiveExample.html")
    public HtmlResource customDirective();

    @Source("UrlHashParameterExample.html")
    public HtmlResource urlHashParameter();
    
    @Source("HttpClientExample.html")
    public HtmlResource httpClient();

    @Source("PrettifyExample.html")
    public HtmlResource prettify();
}
