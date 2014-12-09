package com.asayama.gwt.angular.resources.client.directive;

import com.asayama.gwt.angular.client.AbstractDirective;
import com.asayama.gwt.angular.client.NGScope;
import com.asayama.gwt.jquery.client.JQElement;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

/**
 * Inserts GWT's ImageResource into HTML view via gwt-image-resource attribute
 * directive.
 * <p>
 * Note that GWT ImageResource does not always generate {@code <IMG> } HTML tag,
 * and the DOM created by this object may be far more complex (in order to
 * support inlining of Base64 encoded images, or image spriting).
 * </p><p>
 * http://www.gwtproject.org/doc/latest/DevGuideClientBundle.html#ImageResource
 * </p>
 * 
 * @author kyoken74
 */
public class GwtImageResource extends AbstractDirective {

    /**
     * Creates isolateScope and registers the following attribute definition.
     * <ul>
     * <li>{@code ImageResource} gwt-image-resource</li>
     * </ul>
     */
    @Override
    public NGScope scope() {
        NGScope scope = NGScope.create();
        scope.put(getName(), "=");
        return scope;
    }

    /**
     * Replaces the element body with the ImageResource passed via 
     * gwt-image-resource attribute.
     */
    @Override
    public void link(NGScope scope, JQElement element, JSON attrs) {
        ImageResource resource = scope.get(getName());
        if (resource == null) {
            GWT.log("Mandatory attribute " + getName() + " value is mssing");
            return;
        }
        Image image = new Image(resource);
        Element target = image.asWidget().getElement();
        String className = element.attr("class");
        target.addClassName(className);
        String style = element.attr("style");
        target.setAttribute("style", style);
        element.replaceWith(target);
    }
}
