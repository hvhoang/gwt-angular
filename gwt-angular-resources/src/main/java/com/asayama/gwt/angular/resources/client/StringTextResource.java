package com.asayama.gwt.angular.resources.client;

import com.google.gwt.resources.client.TextResource;


public class StringTextResource implements TextResource {

    private final String string;
    
    public StringTextResource(String string) {
        this.string = string;
    }
    
    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public String getText() {
        return string;
    }
}
