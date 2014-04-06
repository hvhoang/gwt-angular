package com.asayama.gwt.angular.resources.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.jquery.client.Element;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.resources.client.TextResource;


public class GwtTextResource extends AbstractDirective {

    @Override
    public void link(NGScope scope, Element element, JSON attrs) {
        TextResource resource = scope.get(getName());
        if (resource != null) {
            String text = resource.getText();
            element.append(text);
        }
    }
    
    @Override
    public boolean getTransclude() {
        //TODO https://github.com/kyoken74/gwt-angular/issues/62
        return true;
    }
}
