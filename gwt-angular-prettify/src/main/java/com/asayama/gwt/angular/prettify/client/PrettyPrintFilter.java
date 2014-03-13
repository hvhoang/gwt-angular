package com.asayama.gwt.angular.prettify.client;

import com.asayama.gwt.angular.client.AbstractFilter;


public class PrettyPrintFilter extends AbstractFilter {
    
    @Override
    public native String filter(String input) /*-{
        return $wnd.prettyPrintOne(input);
    }-*/;
}