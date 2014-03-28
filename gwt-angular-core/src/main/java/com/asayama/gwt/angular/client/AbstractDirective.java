package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Closure;
import com.google.gwt.resources.client.DataResource;


public abstract class AbstractDirective implements Directive {


    @Override
    public String getRestrict() {
        return "A";
    }

    @Override
    public DataResource getPartial() {
        return null;
    }

    @Override
    public Closure getCompile() {
        return null;
    }
}
