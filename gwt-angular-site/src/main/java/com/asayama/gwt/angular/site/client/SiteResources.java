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
    
    @Source("Jumbotron.html")
    public HtmlResource jumbotron();
    
    @Source("Navbar.html")
    public HtmlResource navbar();
    
    @Source("Footer.html")
    public HtmlResource footer();

}