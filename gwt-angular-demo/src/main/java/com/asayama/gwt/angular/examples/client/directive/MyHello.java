package com.asayama.gwt.angular.examples.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class MyHello extends AbstractDirective {

    @Override
    public TextResource getTemplate() {
        return MyHelloResource.INSTANCE.template();
    }
}

interface MyHelloResource extends ClientBundle {
    
    static final MyHelloResource INSTANCE = GWT.create(MyHelloResource.class);
    
    @Source("MyHello.html")
    TextResource template();
}