package com.asayama.gwt.angular.prettify.client.directive;

import java.util.logging.Logger;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.Injector;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.angular.client.q.Promise.Done;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.angular.prettify.client.Prettifier;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.http.client.Response;
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
 *   public static MyResource RESOURCES = GWT.create(MyResource.class);
 *   public static final TextResource MY_TEXT = RESOURCES.myText();
 * }
 * 
 * // my.txt file content is bound to myText() method.
 * public MyResource extends ClientBundle {
 *   @Source("my.txt")
 *   public TextResource myText();
 * }
 * </pre>
 * 
 * @author kyoken74
 */
public class GwtPrettify extends AbstractDirective {
    
    private static final String CLASS = GwtPrettify.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);
    
    @Injector.Inject
    protected Prettifier prettifier;
    
    @Injector.Inject
    protected HttpClient http;
    
    /**
     * Returns the following restrictions.
     * <ul>
     * <li>{@link Restrict.Attribute, Restrict.Element }</li>
     * </ul>
     */
    @Override
    public Restrict[] getRestrict() {
        return new Restrict[] { Restrict.Attribute, Restrict.Element };
    }
    
    /**
     * Creates isolateScope and registers the following attribute definition.
     * <ul>
     * <li>{@code TextResource} prettify</li>
     * <li>{@code String} prettify</li>
     * </ul>
     */
    @Override
    public NGScope scope() {
        NGScope isolateScope = NGScope.create();
        isolateScope.put(getName(), "=");
        return isolateScope;
    }
    
    /**
     * Replaces the element body with the TextResource passed via gwt-prettify
     * attribute. TextResource is processed by {@link Prettifier} service.
     */
    @Override
    public void link(NGScope isolateScope, final JQElement element, JSON attrs) {
        Object o = isolateScope.get(getName());
        if (o == null) {
            String text = element.text();
            append(element, text);
        } else if (o instanceof String) {
            String filename = (String) o;
            http.get(filename).then(new Done<Response> () {

                @Override
                public void call(Response value) {
                    append(element, value.getText());
                }
            });
        } else if (o instanceof TextResource) {
            TextResource resource = (TextResource) o;
            String text = resource.getText();
            append(element, text);
        } else {
            LOG.warning(getName() + " did not recognize the type of value passed to it.");
        }
    }
    
    private void append(JQElement element, String text) {
        String escaped = SafeHtmlUtils.htmlEscape(text);
        if (text != null && text.length() > 0) {
            element.empty().append(prettifier.prettify(escaped));
        }
        element.addClass("prettyprint");
    }
}
