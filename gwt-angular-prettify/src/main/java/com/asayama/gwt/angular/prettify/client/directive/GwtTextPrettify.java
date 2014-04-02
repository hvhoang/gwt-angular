package com.asayama.gwt.angular.prettify.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGElement;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.angular.prettify.client.filter.Prettify;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;


public class GwtTextPrettify extends AbstractDirective {

    Prettify filter = new Prettify();
    
    @Override
    public void link(NGScope scope, NGElement element, JSON attrs) {
        TextResource resource = scope.get(getName());
        if (resource != null) {
            String text = SafeHtmlUtils.htmlEscape(resource.getText());
            element.append(filter.filter(text));
        } else {
            String text = element.html();
            element.empty();
            element.append(filter.filter(text));
        }
    }
}
