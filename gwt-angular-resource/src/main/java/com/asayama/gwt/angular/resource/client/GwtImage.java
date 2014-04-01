package com.asayama.gwt.angular.resource.client;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;


public class GwtImage extends AbstractDirective {

    @Override
    public TextResource getTemplate() {
        return null; //GwtImageResource.INSTANCE.template();
    }
    
    @Override
    public void link(NGScope scope, Element element, JSON attrs) {
        Image gwtImage = new Image(scope.<ImageResource>get(getName()));
        GWT.log("" + gwtImage.asWidget().getElement());
    }
}

interface GwtImageResource extends ClientBundle {
    
    static final GwtImageResource INSTANCE = GWT.create(GwtImageResource.class);
    
    @Source("GwtImage.html")
    TextResource template();
}