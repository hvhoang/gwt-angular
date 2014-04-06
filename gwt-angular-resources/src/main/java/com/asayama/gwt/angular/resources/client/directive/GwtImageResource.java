package com.asayama.gwt.angular.resources.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.jquery.client.Element;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;


public class GwtImageResource extends AbstractDirective {

    @Override
    public void link(NGScope scope, Element element, JSON attrs) {
        ImageResource resource = scope.get(getName());
        Image image = new Image(resource);
        element.append(image.asWidget().getElement());
    }
}
