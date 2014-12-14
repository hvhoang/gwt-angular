package com.asayama.gwt.angular.client;



public abstract class AbstractFilter implements Filter {

    public abstract String filter(String input);
    
    public String filter(String input, Object... options) {
        return filter(input);
    }
}
