package com.asayama.gwt.angular.client;

import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.resources.client.TextResource;


public abstract class AbstractDirective implements Directive {

    private String name = null;
    
    @Override
    public void onDirectiveLoad() {
        // noop by default
    }
    
    @Override
    public boolean getTransclude() {
        return false;
    }
    
    @Override
    public final String getName() {
        return name;
    }
    
    @Override
    public final void setName(String name) {
        this.name = name;
    }
    
    @Override
    public Restrict[] getRestrict() {
        return new Restrict[]{ Restrict.Attribute };
    }

    @Override
    public TextResource getTemplate() {
        return null;
    }

    @Override
    public String getTemplateUrl() {
        return null;
    }
    
    @Override
    public NGScope scope() {
        return null;
    }

    @Override
    public void compile(JQElement element, JSON attrs) {
        //noop by default
    }
    
    @Override
    public void link(NGScope scope, JQElement element, JSON attrs) {
        // noop by default
    }
}
