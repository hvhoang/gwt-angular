package com.asayama.gwt.angular.prettify.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.prettify.client.filter.Prettify;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;


public class Prettyprint extends AbstractDirective {

    // FIXME https://github.com/kyoken74/gwt-angular/issues/78
    private Prettify filter = new Prettify();
    
    /**
     * Returns the following restrictions.
     * <ul>
     * <li>{@link Restrict.Class}</li>
     * </ul>
     */
    @Override
    public Restrict[] getRestrict() {
        return new Restrict[]{ Restrict.Class };
    }
    
    /**
     * Processes the element body using Prettify filter.
     */
    @Override
    public void compile(JQElement element, JSON attrs) {
        String text = SafeHtmlUtils.htmlEscape(element.text());
        element.empty().append(filter.filter(text));
    }
}
