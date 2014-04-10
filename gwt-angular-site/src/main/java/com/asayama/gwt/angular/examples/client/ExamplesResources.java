package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;


public interface ExamplesResources extends ClientBundle {
    
    public static final ExamplesResources INSTANCE = GWT.create(ExamplesResources.class);
    
    @Source("view/CustomFilterExample.html")
    public HtmlResource customFilter();
    
    @Source("view/CustomDirectiveExample.html")
    public HtmlResource customDirective();
    
    @Source("view/HttpClientExample.html")
    public HtmlResource httpClient();

    @Source("view/ImageResourceExample.html")
    public HtmlResource imageResource();
    
    @Source("view/OnClickEventExample.html")
    public HtmlResource onClickEvent();
    
    @Source("view/PrettifyExample.html")
    public HtmlResource prettify();

    @Source("view/PromiseExample.html")
    public HtmlResource promise();
    
    @Source("view/TextInputExample.html")
    public HtmlResource textInput();

    @Source("view/UrlHashParameterExample.html")
    public HtmlResource urlHashParameter();
}
