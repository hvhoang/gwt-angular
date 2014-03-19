package com.asayama.gwt.angular.sanitize.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface AngularSanitizeScripts extends ClientBundle {

    public static final AngularSanitizeScripts INSTANCE = GWT.create(AngularSanitizeScripts.class);
    
    @Source("angular-sanitize.min.js")
    public TextResource js();
}
