package com.asayama.gwt.angular.resources.client;

import com.asayama.gwt.util.client.Strings;
import com.google.gwt.resources.client.TextResource;


public class StringTextResource implements TextResource {

    private final String[] strings;
    
    public StringTextResource(String... strings) {
        this.strings = strings;
    }
    
    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public String getText() {
        return Strings.concat(strings);
    }
}
