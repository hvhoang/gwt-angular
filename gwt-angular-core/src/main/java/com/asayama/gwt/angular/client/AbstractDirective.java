package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Function;
import com.google.gwt.core.shared.GWT;


public abstract class AbstractDirective implements Directive, Function<Template> {

    public abstract Template template(Object... args);
    
    @Override
    public final Template function(Object... args) {
        try {
            return template(args);
        } catch (Exception e) {
            GWT.log("Exception while building template", e);
            return template("");
        }
    }
}
