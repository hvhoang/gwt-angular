package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Function;
import com.google.gwt.core.shared.GWT;


public interface Directive extends Injectable {

    Template getTemplate();

}

class DirectiveWrapper implements Function<Template> {

    final Directive directive;
    
    DirectiveWrapper(Directive directive) {
        this.directive = directive;
    }
    
    @Override
    public final Template call(Object... args) {
        try {
            return directive.getTemplate();
        } catch (Exception e) {
            GWT.log("Exception while building template", e);
            return directive.getTemplate();
        }
    }
}