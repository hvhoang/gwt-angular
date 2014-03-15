package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Function;


public abstract class AbstractDirective implements Directive, Function<Template> {

    public abstract Template template();
    
    @Override
    public final Template function(Object... args) {
        return template();
    }
}
