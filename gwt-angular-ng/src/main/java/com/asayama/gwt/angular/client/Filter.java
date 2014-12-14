package com.asayama.gwt.angular.client;

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
    void onFilterLoad();
}

class DefaultFilterFactory<F extends Filter> implements Function<NGFilter> {
    
    protected final String name;
    protected final Class<F> klass;
    
    public DefaultFilterFactory(String name, Class<F> klass) {
        this.name = name;
        this.klass = klass;
    }
    
    @Override
    public NGFilter call(Object... args) {

        final Filter filter = FilterCreator.INSTANCE.create(klass);
        final JSClosure binder = FilterBinderFactory.INSTANCE.create(filter);
//        filter.setName(name);
        
        NGFilter jso = NGFilter.create(new Function<String>() {
            @Override
            public String call(Object... args) {
                if (args == null) {
                    return "";
                }

                binder.apply(args);
                
                String input = null;
                if (args.length > 0) {
                    input = (String) args[0];
                }
                
//                try {
//                    LOG.log(Level.FINEST, m = klass.getName() + ".onFilterLoad()");
                    filter.onFilterLoad();
//                } catch (Exception e) {
//                    LOG.log(Level.WARNING, "Exception while calling " + m, e);
//                }

                return filter.filter(input, Arrays.shift(args));
            }
        }).cast();
        return jso;
    }
}

class NGFilter extends JSFunction<String> {

    protected NGFilter() {
    }
}