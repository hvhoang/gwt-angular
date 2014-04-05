package com.asayama.gwt.angular.client;

import com.asayama.gwt.jsni.client.Function;
import com.asayama.gwt.jsni.client.JSClosure;
import com.asayama.gwt.jsni.client.JSFunction;
import com.asayama.gwt.util.client.Arrays;


public interface Filter { //extends Injectable {

    String filter(String input, Object... options);

}

class FilterWrapper implements Function<JSFilter> {
    
    final JSClosure binder;
    final Filter filter;
    
    FilterWrapper(JSClosure binder, Filter filter) {
        this.binder = binder;
        this.filter = filter;
    }
    
    @Override
    public JSFilter call(Object... args) {
        JSFilter jso = JSFilter.create(new Function<String>() {
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
                return filter.filter(input, Arrays.shift(args));
            }
        }).cast();
        return jso;
    }
}

class JSFilter extends JSFunction<String> {

    protected JSFilter() {
    }
}