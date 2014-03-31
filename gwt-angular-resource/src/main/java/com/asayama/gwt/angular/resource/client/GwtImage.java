package com.asayama.gwt.angular.resource.client;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class GwtImage extends AbstractDirective {

    @Override
    public TextResource getTemplate() {
        return GwtImageResource.INSTANCE.template();
    }
}

interface GwtImageResource extends ClientBundle {
    
    static final GwtImageResource INSTANCE = GWT.create(GwtImageResource.class);
    
    @Source("GwtImage.html")
    TextResource template();
}