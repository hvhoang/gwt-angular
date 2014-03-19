package com.asayama.gwt.angular.route.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface AngularRouteScripts extends ClientBundle {

    public static final AngularRouteScripts INSTANCE = GWT.create(AngularRouteScripts.class);
    
    @Source("angular-route.min.js")
    public TextResource js();
}
