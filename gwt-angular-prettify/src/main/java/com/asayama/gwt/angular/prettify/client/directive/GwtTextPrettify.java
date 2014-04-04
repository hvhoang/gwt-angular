package com.asayama.gwt.angular.prettify.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGElement;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.angular.prettify.client.filter.Prettify;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

/**
 * Applies google-code-prettify style to a TextResource. This is an attribute
 * directive.
 * <pre>{@code 
 * <pre data-gwt-text-prettify="MY_TEXT"></pre>
 * }</pre>
 * 
 * The above code shows the scope variable MY_TEXT of type TextResource is bound
 * to the &lt;pre&gt; element.
 * <pre>
 * // Controller defines MY_TEXT which is bound the the controller's scope.
 * public MyController implements Controller {
 *   public static final TextResource MY_TEXT = MyResource.INSTANCE.myText();
 *   ...
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
public class GwtTextPrettify extends AbstractDirective {

    //TODO https://github.com/kyoken74/gwt-angular/issues/52
    private Prettify filter = new Prettify();
    
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
