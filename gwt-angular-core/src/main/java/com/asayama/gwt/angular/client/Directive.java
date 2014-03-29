package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.Directive.Restrict;
import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.JSClosure;
import com.asayama.gwt.core.client.JSON;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.Element;


public interface Directive extends Injectable {
    
    public static enum Restrict {
        
        Attribute('A'),
        Class('C'),
        Element('E'),
        Comment('M');
        
        final char code;
        
        Restrict(char code) {
            this.code = code;
        }
    }

    String getName();
    TextResource getTemplate();
    DataResource getPartial();
    Restrict[] getRestrict();
    void getCompile(Element element, JSON attrs);
}

class DirectiveWrapper implements Function<JSDirective> {

    final Directive directive;
    
    DirectiveWrapper(Directive directive) {
        this.directive = directive;
    }
    
    @Override
    public final JSDirective call(Object... args) {

        JSDirective jso = JSDirective.create();
        
        try {
            
            Restrict[] rs = directive.getRestrict();
            if (rs != null) {
                StringBuilder sb = new StringBuilder();
                for (Restrict r : rs) {
                    sb.append(r.code);
                }
                jso.setRestrict(sb.toString());
            }
            
            TextResource template = directive.getTemplate();
            if (template != null) {
                jso.setTemplate(template.getText());
            }
            
            DataResource partial = directive.getPartial();
            if (partial != null) {
                jso.setTemplateUrl(partial.getSafeUri().asString());
            }
            
            jso.setCompile(JSClosure.create(new Closure() {
                @Override
                public void exec(Object... args) {
                    try {
                        assert (args == null || args.length < 2);
                        Element element = (Element) args[0];
                        JSON attrs = (JSON) args[1];
                        directive.getCompile(element, attrs);
                    } catch (Exception e) {
                        GWT.log("Exception while calling Directive.getCompile");
                    }
                }
            }));
            
            JSON scope = JSON.create();
            //FIXME the value of the attribute directive is not properly passed to the template
            //https://github.com/kyoken74/gwt-angular/issues/36
            scope.put(directive.getName(), "=");
            jso.setScope(scope);
            
            return jso;
            
        } catch (Exception e) {
            GWT.log("Exception while building a directive", e);
            return jso;
        }
    }
}

class JSDirective extends JSON {

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
    
    final JSDirective setScope(JSON scope) {
        put("scope", scope);
        return this;
    }
}
