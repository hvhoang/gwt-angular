package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.JSClosure;
import com.asayama.gwt.core.client.JSON;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.TextResource;


public interface Directive extends Injectable {

    TextResource getTemplate();
    DataResource getPartial();
    String getRestrict();
    Closure getCompile();
}

class DirectiveWrapper implements Function<JSDirective> {

    final Directive directive;
    
    DirectiveWrapper(Directive directive) {
        this.directive = directive;
    }
    
    @Override
    public final JSDirective call(Object... args) {
        JSDirective jso = JSDirective.create("");
        try {
            if (directive.getRestrict() != null) {
                jso.setRestrict(directive.getRestrict());
            }
            if (directive.getTemplate() != null) {
                jso.setTemplate(directive.getTemplate().getText());
            }
            if (directive.getPartial() != null) {
                jso.setTemplateUrl(directive.getPartial().getSafeUri().asString());
            }
            if (directive.getCompile() != null) {
                jso.setCompile(JSClosure.create(directive.getCompile()));
            }
            return jso;
        } catch (Exception e) {
            GWT.log("Exception while building template", e);
            return jso;
        }
    }
}

class JSDirective extends JSON {

    static native JSDirective create(String defaultTemplate) /*-{
        return {
            "restrict" : "A"
        };
    }-*/;
    
    protected JSDirective() {
    }
    
    final JSDirective setRestrict(String restrict) {
        put("restrict", restrict);
        return this;
    }
    
    final JSDirective setTemplate(String template) {
        put("template", template);
        return this;
    }

    final JSDirective setTemplateUrl(String templateUrl) {
        put("templateUrl", templateUrl);
        return this;
    }
    
    final JSDirective setCompile(JSClosure compile) {
        put("compile", compile);
        return this;
    }
}
