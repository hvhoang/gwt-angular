package com.asayama.gwt.angular.prettify.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGElement;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.angular.prettify.client.filter.Prettify;
import com.asayama.gwt.jsni.client.JSON;

/**
 * Applies google-code-prettify style to an inline HTML text. This is a class
 * directive.
 * <pre>{@code 
 * <pre class="gwt-prettify">
 * &lt;h1&gt;Hello, World!&lt;/h1&gt;
 * </pre>
 * }</pre>
 * 
 * Note that, if you want to inline an HTML or XML text, you must escape all the
 * HTML code manually. While this is feasible for small code snippets, for 
 * larger text, consider separating the text into its own file, and use a 
 * TextResource based {@link GwtTextPrettify} instead.
 * 
 * @author kyoken74
 */
public class GwtPrettify extends AbstractDirective {

    //TODO https://github.com/kyoken74/gwt-angular/issues/52
    private Prettify filter = new Prettify();
    
    @Override
    public Restrict[] getRestrict() {
        return new Restrict[]{ Restrict.Class };
    }
    
    //TODO https://github.com/kyoken74/gwt-angular/issues/62
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
