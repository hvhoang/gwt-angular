package com.asayama.gwt.angular.prettify.client.resources;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public interface PrettifyScripts extends ClientBundle {
    
    static PrettifyScripts INSTANCE = GWT.create(PrettifyScripts.class);
    
    @Source("prettify.css")
    TextResource css();

    @Source("prettify.js")
    TextResource js();
}