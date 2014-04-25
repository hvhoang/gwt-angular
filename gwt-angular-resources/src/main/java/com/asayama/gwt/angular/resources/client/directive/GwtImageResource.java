package com.asayama.gwt.angular.resources.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;


public class GwtImageResource extends AbstractDirective {

	@Override
	public NGScope scope() {
		return NGScope.create();
	}
	
    @Override
    public void link(NGScope scope, JQElement element, JSON attrs) {
        ImageResource resource = scope.get(getName());
        Image image = new Image(resource);
        Element target = image.asWidget().getElement();
        String className= element.attr("class");
        target.addClassName(className);
        element.replaceWith(target);
    }
}
