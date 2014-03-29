package com.asayama.gwt.angular.tutorial.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.core.client.JSON;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.Element;

//**
//* {{ agIncludeRemote }}
//*
public class FooDirective extends AbstractDirective {

    public FooDirective(String name) {
        super(name);
    }
    
    @Override
    public TextResource getTemplate() {
        return FooDirectiveResource.INSTANCE.template();
    }
    
//    @Override
//    public DataResource getPartial() {
//        return IncludeRemoteDirectiveResource.INSTANCE.partial();
//    }
    
    @Override
    public void getCompile(Element element, JSON attrs) {
        // TODO Auto-generated method stub
    }
}

interface FooDirectiveResource extends ClientBundle {
    
    static final FooDirectiveResource INSTANCE =
            GWT.create(FooDirectiveResource.class);
    
    @Source("FooDirective.html")
    TextResource template();
    
    @DoNotEmbed
    @MimeType("text/plain")
    @Source("FooDirective.html")
    DataResource partial();
}