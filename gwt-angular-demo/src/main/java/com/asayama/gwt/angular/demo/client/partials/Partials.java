package com.asayama.gwt.angular.demo.client.partials;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;


public interface Partials extends ClientBundle {
    
    public static final Partials INSTANCE = GWT.create(Partials.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("documentation.html")
    public DataResource documentation();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("downloads.html")
    public DataResource downloads();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("examples.html")
    public DataResource examples();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("jumbotron.html")
    public DataResource jumbotron();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("navbar.html")
    public DataResource navbar();
    
}