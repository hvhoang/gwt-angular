package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;


public interface ExamplesResources extends ClientBundle {
    
    public static final ExamplesResources INSTANCE = GWT.create(ExamplesResources.class);

    @Source("view/Examples.html")
    public HtmlResource examples();
    
    @Source("view/TextInputExample.html")
    public HtmlResource textInput();
    
    @Source("view/OnClickEventExample.html")
    public HtmlResource onClickEvent();
    
    @Source("view/ReverseFilterExample.html")
    public HtmlResource reverseFilter();
    
    @Source("view/CustomDirectiveExample.html")
    public HtmlResource customDirective();

    @Source("view/UrlHashParameterExample.html")
    public HtmlResource urlHashParameter();
    
    @Source("view/HttpClientExample.html")
    public HtmlResource httpClient();

    @Source("view/PrettifyExample.html")
    public HtmlResource prettify();
}
