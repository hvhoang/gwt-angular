package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.JSON;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.user.client.Element;


public abstract class AbstractDirective implements Directive {

    private final String name;
    
    public AbstractDirective(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public Restrict[] getRestrict() {
        return null;
    }

    @Override
    public DataResource getPartial() {
        return null;
    }

    @Override
    public void getCompile(Element element, JSON attrs) {
    }
}
