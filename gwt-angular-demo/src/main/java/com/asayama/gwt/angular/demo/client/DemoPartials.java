package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Partial;
import com.asayama.gwt.angular.client.Partials;
import com.google.gwt.core.client.GWT;


public interface DemoPartials extends Partials {
    
    public static final DemoPartials INSTANCE = GWT.create(DemoPartials.class);
    
    @Resource("Documentation.html")
    public Partial documentation();
    
    @Resource("Downloads.html")
    public Partial downloads();
    
    @Resource("Jumbotron.html")
    public Partial jumbotron();
    
    @Resource("Navbar.html")
    public Partial navbar();   
}