package com.asayama.gwt.angular.examples.client.view.demo;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;


public interface ExamplesDemoPartials extends ClientBundle {

    static final ExamplesDemoPartials INSTANCE = GWT.create(ExamplesDemoPartials.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("CustomDirectiveExample.html")
    DataResource customDirectiveExample();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("HttpClientExample.html")
    DataResource httpClient();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("OnClickEventExample.html")
    DataResource onClickEvent();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("PrettifyExample.html")
    DataResource prettify();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("ReverseFilterExample.html")
    DataResource reverseFilter();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("TextInputExample.html")
    DataResource textInput();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("UrlHashParameterExample.html")
    DataResource urlHashParameter();
    
}
