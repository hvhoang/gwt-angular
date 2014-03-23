package com.asayama.gwt.angular.tutorial.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;


public interface SamplePartials extends ClientBundle {

    public static final SamplePartials INSTANCE = GWT.create(SamplePartials.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("sample.html")
    public DataResource sample();
}
