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
    void compile(JQElement element, JSON attrs);
    void link(NGScope scope, JQElement element, JSON attrs);
    void onDirectiveLoad();
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

        NGDirective ngo = NGDirective.create();
        
        try {
            final Directive directive = DirectiveCreator.INSTANCE.create(klass);
            final JSClosure binder = DirectiveBinderFactory.INSTANCE.create(directive);
            
            directive.setName(name);
            
            Restrict[] rs = directive.getRestrict();
            if (rs != null && rs.length > 0) {
                StringBuilder sb = new StringBuilder();
                for (Restrict r : rs) {
                    sb.append(r.code);
                }
                ngo.setRestrict(sb.toString());
            }

//            jso.setTransclude(directive.getTransclude());

            TextResource template = directive.getTemplate();
            if (template != null) {
                ngo.setTemplate(template.getText());
            }
            
            String templateUrl = directive.getTemplateUrl();
            if (templateUrl != null) {
                ngo.setTemplateUrl(templateUrl);
            }
            
            ngo.setCompile(JSFunction.create(new Function<JSClosure>() {
                
                @Override
                public JSClosure call(Object... args) {
                    try {
                        JQElement element = (JQElement) args[0];
                        JSON attrs = (JSON) args[1];
                        directive.compile(element, attrs);
                        return JSClosure.create(new Closure() {
                            @Override
                            public void exec(Object... args) {
                                try {
                                    NGScope scope = (NGScope) args[0];
                                    JQElement element = (JQElement) args[1];
                                    JSON attrs = (JSON) args[2];
                                    directive.link(scope, element, attrs);
                                } catch (Exception e) {
                                    LOG.log(Level.FINEST, "Exception while calling " + name + ".link()", e);
                                }
                            }
                        });
                    } catch (Exception e) {
                        LOG.log(Level.WARNING, "Exception while calling " + name + ".compile()", e);
                        return JSClosure.create(new Closure() {
                            public void exec(Object... args) {
                                LOG.log(Level.WARNING, "Unable to call " + name + ".link(). See previous compile() errors");
                            }
                        });
                    }
                }
            }));
            
            NGScope scope = directive.scope();
//            if (scope != null && scope.get(directive.getName()) == null) {
//                scope.put(directive.getName(), "=");
//            }
            ngo.setScope(scope);
            
            binder.apply(args);
            
//            try {
                //LOG.log(Level.FINEST, m = klass.getName() + ".onDirectiveLoad()");
                directive.onDirectiveLoad();
//            } catch (Exception e) {
//                LOG.log(Level.WARNING, "Exception while calling " + m, e);
//            }

            return ngo;
            
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Exception while building a directive", e);
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
