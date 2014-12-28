package com.asayama.gwt.angular.prettify.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.prettify.client.Prettifier;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;


public class Prettyprint extends AbstractDirective {

    @Injector.Inject
    protected Prettifier prettifier;    

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
        element.empty().append(prettifier.prettify(text));
    }
}
