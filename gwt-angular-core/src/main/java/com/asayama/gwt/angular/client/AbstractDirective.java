package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Function;
import com.google.gwt.core.shared.GWT;


public abstract class AbstractDirective implements Directive, Function<Template> {

    public abstract Template getTemplate();
    
    @Override
    public final Template call(Object... args) {
        try {
            return getTemplate();
        } catch (Exception e) {
            GWT.log("Exception while building template", e);
            return getTemplate();
        }
    }
}
