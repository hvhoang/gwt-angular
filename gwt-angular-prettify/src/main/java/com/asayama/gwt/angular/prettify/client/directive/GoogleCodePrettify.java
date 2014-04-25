package com.asayama.gwt.angular.prettify.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.angular.prettify.client.filter.Prettify;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;


public class GoogleCodePrettify extends AbstractDirective {

    //TODO https://github.com/kyoken74/gwt-angular/issues/52
    private Prettify filter = new Prettify();
    
    @Override
    public Restrict[] getRestrict() {
        return new Restrict[]{ Restrict.Class };
    }
    
//    @Override
//    public NGScope scope() {
//    	return NGScope.create();
//    }
    
    @Override
    public void link(NGScope scope, JQElement element, JSON attrs) {
        String text = SafeHtmlUtils.htmlEscape(element.text());
        element.empty().append(filter.filter(text));
        element.addClass("prettyprint");
    }
}
