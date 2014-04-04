package com.asayama.gwt.angular.examples.client.view.docs;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;


public interface ExamplesDocsPartials extends ClientBundle {
    
    public static final ExamplesDocsPartials INSTANCE = GWT.create(ExamplesDocsPartials.class);

    @DoNotEmbed
    @MimeType("text/html")
    @Source("Examples.html")
    public DataResource examples();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("TextInputExample.html")
    public DataResource textInput();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("OnClickEventExample.html")
    public DataResource onClickEvent();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("ReverseFilterExample.html")
    public DataResource reverseFilter();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("CustomDirectiveExample.html")
    public DataResource customDirective();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("UrlHashParameterExample.html")
    public DataResource urlHashParameter();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("HttpClientExample.html")
    public DataResource httpClient();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("PrettifyExample.html")
    public DataResource prettify();
}
