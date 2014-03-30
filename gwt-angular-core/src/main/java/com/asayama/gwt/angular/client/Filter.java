package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.JSFunction;
import com.asayama.gwt.core.client.util.Arrays;


public interface Filter {

    String filter(String input, Object... options);

}

class FilterWrapper implements Function<JSFilter> {
    
    final Filter filter;
    
    FilterWrapper(Filter filter) {
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