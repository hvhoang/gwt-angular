package com.asayama.gwt.angular.site.examples.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class MyHello extends AbstractDirective {

    @Override
    public TextResource getTemplate() {
        return MyHelloResource.INSTANCE.template();
    }
    
    @Override
    public NGScope scope() {
    	return NGScope.create();
    }
}

interface MyHelloResource extends ClientBundle {
    
    static final MyHelloResource INSTANCE = GWT.create(MyHelloResource.class);
    
    @Source("MyHello.html")
    TextResource template();
}