package com.asayama.gwt.angular.examples.client.partials;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;


public interface ExamplesPartials extends ClientBundle {
    
    public static final ExamplesPartials INSTANCE = GWT.create(ExamplesPartials.class);

    @DoNotEmbed
    @MimeType("text/html")
    @Source("Examples.html")
    public DataResource examples();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("HttpClientExample.html")
    public DataResource httpClient();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("OnClickEventExample.html")
    public DataResource onClickEvent();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("PrettifyExample.html")
    public DataResource prettify();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("ReverseFilterExample.html")
    public DataResource reverseFilter();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("TextInputExample.html")
    public DataResource textInput();

    @DoNotEmbed
    @MimeType("text/html")
    @Source("UrlHashParameterExample.html")
    public DataResource urlHashParameter();

}
