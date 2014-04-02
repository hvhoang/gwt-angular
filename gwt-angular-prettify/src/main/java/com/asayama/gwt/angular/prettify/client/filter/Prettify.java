package com.asayama.gwt.angular.prettify.client.filter;

import com.asayama.gwt.angular.client.AbstractFilter;


public class Prettify extends AbstractFilter {
    
    @Override
    public native String filter(String input) /*-{
        return $wnd.prettyPrintOne(input);
    }-*/;
}