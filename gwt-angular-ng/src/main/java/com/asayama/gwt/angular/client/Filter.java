package com.asayama.gwt.angular.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.jsni.client.Function;
import com.asayama.gwt.jsni.client.JSClosure;
import com.asayama.gwt.jsni.client.JSFunction;
import com.asayama.gwt.util.client.Arrays;

/**
 * TODO This file needs some serious review and clean-up.
 * 
 * @author kyoken74
 */
public interface Filter {

    String filter(String input, Object... options);
}

class DefaultFilterFactory<F extends Filter> implements Function<NGFilter> {

    private static final String CLASS = DefaultFilterFactory.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);
    
    protected final String name;
    protected final Class<F> klass;
    
    DefaultFilterFactory(String name, Class<F> klass) {
        this.name = name;
        this.klass = klass;
    }
    
    @Override
    public NGFilter call(Object... args) {

        String m = "entering";
        
        try {
            
            m = "creating filter " + name;
            final Filter filter = FilterCreator.INSTANCE.create(klass);
            
            m = "creating NGFilter for " + name;
            NGFilter ngo = NGFilter.create(new Function<String>() {
                
                @Override
                public String call(Object... args) {
                    
                    String m = "entering";
                    
                    try {
                        
                        if (args == null) {
                            return "";
                        }
                        
                        m = "creating binder for " + name;
                        JSClosure binder = FilterBinderFactory.INSTANCE.create(filter);
                        
                        m = "applying binder to " + name;
                        binder.apply(args);
                        
                        m = "identifying the input string";
                        String input = null;
                        if (args.length > 0) {
                            input = (String) args[0];
                        }
                        
                        LOG.finest(m = "calling " + klass.getName() + ".filter");
                        return filter.filter(input, Arrays.shift(args));
                        
                    } catch (Exception e) {
                        LOG.log(Level.WARNING, "Exception while " + m, e);
                        return "";
                    }
                }
            }).cast();
            
            m = "returning NGFilter for " + name;
            return ngo;
            
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Exception while " + m, e);
            return null;
        }
    }
}

class NGFilter extends JSFunction<String> {

    protected NGFilter() {
    }
    
}
