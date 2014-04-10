package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface SiteResources extends ClientBundle {
    
    public static final SiteResources INSTANCE = GWT.create(SiteResources.class);
    
    @Source("Documentation.html")
    public HtmlResource documentation();
    
    @Source("Downloads.html")
    public HtmlResource downloads();
    
    @Source("Examples.html")
    public HtmlResource examples();

    @Source("Footer.html")
    public HtmlResource footer();

    @Source("Jumbotron.html")
    public HtmlResource jumbotron();
    
    @Source("Navbar.html")
    public HtmlResource navbar();
    
    @Source("Tutorial.html")
    public HtmlResource tutorial();
    
}