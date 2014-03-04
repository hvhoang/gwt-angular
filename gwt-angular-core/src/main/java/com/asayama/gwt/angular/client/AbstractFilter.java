package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.util.Arrays;


public abstract class AbstractFilter implements Function<String> {

    public abstract String filter(String input);
    
    public String filter(String input, Object... options) {
        return filter(input);
    }
    
    @Override
    public final String function(Object... args) {
        if (args == null) {
            return "";
        }
        String input = null;
        if (args.length > 0) {
            input = (String) args[0];
        }
        return filter(input, Arrays.shift(args));
    }
}
