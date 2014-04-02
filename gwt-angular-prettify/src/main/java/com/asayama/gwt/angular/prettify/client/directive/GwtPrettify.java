package com.asayama.gwt.angular.prettify.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGElement;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.angular.prettify.client.filter.Prettify;
import com.asayama.gwt.jsni.client.JSON;


public class GwtPrettify extends AbstractDirective {

    Prettify filter = new Prettify();
    
    @Override
    public Restrict[] getRestrict() {
        return new Restrict[]{ Restrict.Class };
    }
    
    @Override
    public boolean getTransclude() {
        return true;
    }
    
    @Override
    public void link(NGScope scope, NGElement element, JSON attrs) {
        String text = element.html();
        element.empty();
        element.append(filter.filter(text));
    }
}
