package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.JSON;
import com.google.gwt.user.client.Element;


public abstract class AbstractDirective implements Directive {
    
    @Override
    public Restrict[] getRestrict() {
        return new Restrict[]{ Restrict.Attribute };
    }

    @Override
    public Partial getPartial() {
        return null;
    }

    @Override
    public void compile(Element element, JSON attrs) {
    }
    
    @Override
    public JSON getScope() {
        return JSON.create();
    }
}
