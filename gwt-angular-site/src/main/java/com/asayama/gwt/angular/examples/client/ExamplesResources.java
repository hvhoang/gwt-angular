package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;


public interface ExamplesResources extends ClientBundle {
    
    public static final ExamplesResources INSTANCE = GWT.create(ExamplesResources.class);

    @Source("Examples.html")
    public HtmlResource examples();
    
    @Source("TextInputExample.html")
    public HtmlResource textInput();
    
    @Source("OnClickEventExample.html")
    public HtmlResource onClickEvent();
    
    @Source("CustomFilterExample.html")
    public HtmlResource customFilter();
    
    @Source("CustomDirectiveExample.html")
    public HtmlResource customDirective();

    @Source("UrlHashParameterExample.html")
    public HtmlResource urlHashParameter();
    
    @Source("HttpClientExample.html")
    public HtmlResource httpClient();

    @Source("PrettifyExample.html")
    public HtmlResource prettify();
    
    @Source("ImageSpritingExample.html")
    public HtmlResource imageSpriting();
}
