package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface SiteResources extends ClientBundle {
    
    public static final SiteResources INSTANCE = GWT.create(SiteResources.class);
    
    @Source("view/Documentation.html")
    public HtmlResource documentation();
    
    @Source("view/Downloads.html")
    public HtmlResource downloads();
    
    @Source("view/Examples.html")
    public HtmlResource examples();

    @Source("view/Footer.html")
    public HtmlResource footer();

    @Source("view/Jumbotron.html")
    public HtmlResource jumbotron();
    
    @Source("view/Navbar.html")
    public HtmlResource navbar();
    
    @Source("view/Tutorial.html")
    public HtmlResource tutorial();
    
}