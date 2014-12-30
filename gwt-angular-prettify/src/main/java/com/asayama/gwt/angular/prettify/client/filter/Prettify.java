package com.asayama.gwt.angular.prettify.client.filter;

import com.asayama.gwt.angular.client.AbstractFilter;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.prettify.client.Prettifier;


public class Prettify extends AbstractFilter {

    @Injector.Inject
    protected Prettifier prettifier;
    
    @Override
    public String filter(String input) {
        return prettifier.prettify(input);
    }    
}