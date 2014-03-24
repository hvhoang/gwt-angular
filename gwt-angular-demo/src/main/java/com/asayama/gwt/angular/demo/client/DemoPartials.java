package com.asayama.gwt.angular.demo.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;


public interface DemoPartials extends ClientBundle {
    
    public static final DemoPartials INSTANCE = GWT.create(DemoPartials.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("Documentation.html")
    public DataResource documentation();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("Downloads.html")
    public DataResource downloads();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("Jumbotron.html")
    public DataResource jumbotron();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("Navbar.html")
    public DataResource navbar();
    
}