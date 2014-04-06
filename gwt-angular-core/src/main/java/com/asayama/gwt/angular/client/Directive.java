package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.Directive.Restrict;
import com.asayama.gwt.jquery.client.Element;
import com.asayama.gwt.jsni.client.Closure;
import com.asayama.gwt.jsni.client.Function;
import com.asayama.gwt.jsni.client.JSClosure;
import com.asayama.gwt.jsni.client.JSFunction;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.TextResource;


public interface Directive {
    
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
    boolean getTransclude();
    void setName(String name);
    Restrict[] getRestrict();
    TextResource getTemplate();
    String getTemplateUrl();
    void compile(Element element, JSON attrs);
    void link(NGScope scope, Element element, JSON attrs);
}

class DirectiveWrapper implements Function<JSDirective> {

    final JSClosure binder;
    final Directive directive;
    
    DirectiveWrapper(JSClosure binder, Directive directive) {
        this.binder = binder;
        this.directive = directive;
    }
    
    @Override
    public final JSDirective call(Object... args) {

        JSDirective jso = JSDirective.create();
        
        try {
            final String name = directive == null ? null : directive.getName();
            
            Restrict[] rs = directive.getRestrict();
            if (rs != null && rs.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (Restrict r : rs) {
                    sb.append(r.code);
                }
                jso.setRestrict(sb.toString());
            }

            jso.setTransclude(directive.getTransclude());

            TextResource template = directive.getTemplate();
            if (template != null) {
                jso.setTemplate(template.getText());
            }
            
            String templateUrl = directive.getTemplateUrl();
            if (templateUrl != null) {
                jso.setTemplateUrl(templateUrl);
            }
            
            jso.setCompile(JSFunction.create(new Function<JSClosure>() {
                
                @Override
                public JSClosure call(Object... args) {
                    try {
                        Element element = (Element) args[0];
                        JSON attrs = (JSON) args[1];
                        directive.compile(element, attrs);
                        return JSClosure.create(new Closure() {
                            @Override
                            public void exec(Object... args) {
                                try {
                                    NGScope scope = (NGScope) args[0];
                                    Element element = (Element) args[1];
                                    JSON attrs = (JSON) args[2];
                                    directive.link(scope, element, attrs);
                                } catch (Exception e) {
                                    GWT.log("Exception while calling " + name + ".link()", e);
                                }
                            }
                        });
                    } catch (Exception e) {
                        GWT.log("Exception while calling " + name + ".compile()", e);
                        return JSClosure.create(new Closure() {
                            public void exec(Object... args) {
                                GWT.log("Unable to call " + name + ".link(). See previous compile() errors");
                            }
                        });
                    }
                }
            }));
            
            JSON json = JSON.create();
            json.put(directive.getName(), "=");
            jso.setScope(json);
            
            binder.apply(args);
            
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
    
    final void setRestrict(String restrict) {
        put("restrict", restrict);
    }
    
    final void setTemplate(String template) {
        put("template", template);
    }

    final void setTemplateUrl(String templateUrl) {
        put("templateUrl", templateUrl);
    }
    
    final void setTransclude(boolean transclude) {
        put("transclude", transclude);
    }
    
    final void setCompile(JSFunction<JSClosure> compile) {
        put("compile", compile);
    }
    
    final void setScope(JSON scope) {
        put("scope", scope);
    }
}
