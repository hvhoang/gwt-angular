package com.asayama.gwt.angular.prettify.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.angular.prettify.client.filter.Prettify;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

/**
 * Applies google-code-prettify style to a TextResource. This is an attribute
 * directive.
 * <pre>{@code 
 * <pre data-gwt-prettify="MY_TEXT"></pre>
 * }</pre>
 * 
 * The above code shows the scope variable MY_TEXT of type TextResource is bound
 * to the &lt;pre&gt; element.
 * <pre>
 * // Controller defines MY_TEXT which is bound the the controller's scope.
 * public MyController implements Controller {
 *   public static final TextResource MY_TEXT = MyResource.INSTANCE.myText();
 * }
 * 
 * // my.txt file content is bound to myText() method.
 * public MyResource extends ClientBundle {
 *   public static MyResource INSTANCE = GWT.create(MyResource.class);
 *   @Source("my.txt")
 *   public TextResource myText();
 * }
 * </pre>
 * 
 * @author kyoken74
 */
public class GwtPrettify extends AbstractDirective {

    // FIXME https://github.com/kyoken74/gwt-angular/issues/78
    private Prettify filter = new Prettify();
    
    /**
     * Returns the following restrictions.
     * <ul>
     * <li>{@link Restrict.Attribute}</li>
     * </ul>
     */
    @Override
    public Restrict[] getRestrict() {
        return new Restrict[]{ Restrict.Attribute };
    }
    
    /**
     * Creates isolateScope and registers the following attribute definition.
     * <ul>
     * <li>{@code TextResource} gwt-prettify</li>
     * </ul>
     */
    @Override
    public NGScope scope() {
        NGScope scope = NGScope.create();
        scope.put(getName(), "=");
        return scope;
    }
    
    /**
     * Replaces the element body with the TextResource passed via gwt-prettify
     * attribute. TextResource is processed by {@link Prettify} filter.
     */
    @Override
    public void link(NGScope scope, JQElement element, JSON attrs) {
        TextResource resource = scope.get(getName());
        if (resource == null) {
            GWT.log("Mandatory attribute, " + getName() + ", was missing");
            return;
        }
        String text = SafeHtmlUtils.htmlEscape(resource.getText());
        if (text != null && text.length() > 0) {
            element.empty().append(filter.filter(text));
        }
        element.addClass("prettyprint");
    }
}
