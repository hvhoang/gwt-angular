package com.asayama.gwt.angular.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface AngularScripts extends ClientBundle {

    public static final AngularScripts INSTANCE = GWT.create(AngularScripts.class);
    
    @Source("angular.min.js")
    public TextResource js();
}
