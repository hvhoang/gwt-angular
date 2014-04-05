package com.asayama.gwt.angular.demo.client.view;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface DemoResources extends ClientBundle {
    
    public static final DemoResources INSTANCE = GWT.create(DemoResources.class);
    
    @Source("Documentation.html")
    public HtmlResource documentation();
    
    @Source("Downloads.html")
    public HtmlResource downloads();
    
    @Source("Jumbotron.html")
    public HtmlResource jumbotron();
    
    @Source("Navbar.html")
    public HtmlResource navbar();
    
    @Source("Footer.html")
    public HtmlResource footer();
}