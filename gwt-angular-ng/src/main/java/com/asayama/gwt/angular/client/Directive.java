package com.asayama.gwt.angular.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.Directive.Restrict;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.Closure;
import com.asayama.gwt.jsni.client.Function;
import com.asayama.gwt.jsni.client.JSClosure;
import com.asayama.gwt.jsni.client.JSFunction;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.resources.client.TextResource;

/**
 * TODO This file needs some serious review and clean-up.
 * 
 * @author kyoken74
 */
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
    
    NGScope scope();
    
    /**
     * In AngularJS, compile method returns linker function. In this 
     * implementation, however, we do not return any values. This is because 
     * {@link DefaultDirectiveFactory} wraps the call to 
     * {@link #link(NGScope, JQElement, JSON)} into a JavaScript function, and
     * returns that from the JavaScript wrapping of the compile function call.
     * <p>
     * This means that, unlike AngularJS, we currently do not support compile
     * dependent linker option (i.e. the outcome of compile function cannot
     * return different linker functions).
     * </p>
     */
    void compile(JQElement element, JSON attrs);
    
    void link(NGScope scope, JQElement element, JSON attrs);
}

class DefaultDirectiveFactory<D extends Directive>  implements Function<NGDirective> {

    private static final String CLASS = DefaultDirectiveFactory.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

    protected final String name;
    protected final Class<D> klass;
    
    DefaultDirectiveFactory(String name, Class<D> klass) {
        this.name = name;
        this.klass = klass;
    }
    
    @Override
    public NGDirective call(Object... args) {

        String m = "creating NGDirective for " + name;
        NGDirective ngo = NGDirective.create();
        
        try {
            
            m = "creating directive " + name;
            final Directive directive = DirectiveCreator.INSTANCE.create(klass);
            directive.setName(name);

            m = "determining directive restriction for " + name;
            Restrict[] rs = directive.getRestrict();
            if (rs != null && rs.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (Restrict r : rs) {
                    sb.append(r.code);
                }
                ngo.setRestrict(sb.toString());
            }

            // TODO jso.setTransclude(directive.getTransclude());

            m = "setting directive template for " + name;
            TextResource template = directive.getTemplate();
            if (template != null) {
                ngo.setTemplate(template.getText());
            }
            
            m = "setting directive templateUrl for " + name;
            String templateUrl = directive.getTemplateUrl();
            if (templateUrl != null) {
                ngo.setTemplateUrl(templateUrl);
            }
            
            m = "setting directive compile for " + name;
            ngo.setCompile(JSFunction.create(new Function<JSClosure>() {
                
                @Override
                public JSClosure call(Object... args) {
                    try {
                        LOG.finest("calling " + name + ".compile()");
                        JQElement element = (JQElement) args[0];
                        JSON attrs = (JSON) args[1];
                        directive.compile(element, attrs);
                        return JSClosure.create(new Closure() {
                            @Override
                            public void exec(Object... args) {
                                try {
                                    LOG.finest("calling " + name + ".link()");
                                    NGScope scope = (NGScope) args[0];
                                    JQElement element = (JQElement) args[1];
                                    JSON attrs = (JSON) args[2];
                                    directive.link(scope, element, attrs);
                                } catch (Exception e) {
                                    LOG.log(Level.WARNING, "Exception while calling " + name + ".link()", e);
                                }
                            }
                        });
                    } catch (Exception e) {
                        LOG.log(Level.WARNING, "Exception while calling " + name + ".compile()", e);
                        return null;
                    }
                }
            }));
            
            m = "getting directive scope for " + name;
            NGScope scope = directive.scope();
            
            m = "setting directive scope for " + name;
            ngo.setScope(scope);
            
            m = "creating binder for " + name;
            JSClosure binder = DirectiveBinderFactory.INSTANCE.create(directive);
            
            m = "applying binder to " + name;
            binder.apply(args);
            
            m = "returning NGDirective";
            return ngo;
            
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Exception while " + m, e);
            return ngo;
        }
    }
}

/**
 * https://docs.angularjs.org/api/ng/service/$compile
 * 
 * @author kyoken74
 */
class NGDirective extends JSON {

    protected NGDirective() {
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
    
    /**
     * If scope argument is null, this sets the scope to true, which implies
     * that a local scope is created inheriting the parent scope. If scope
     * value is not null, then a local isolate scope is created.
     */
    final native void setScope(NGScope scope) /*-{
        this.scope = scope ? scope : true;
    }-*/;
}
