package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractFilter;
import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

/**
 * <pre>{@code 
 * public class ExamplesModule extends AbstractModule implements EntryPoint {
 * 
 *   public void onModuleLoad() {
 *     Angular.module(this);
 *     ...
 *     // Register custom filter with the modules, and you can use it in HTML.
 *     // In this example, we override the default filter name (which is the 
 *     // class name, with a short-hand "reverse").
 *     filter("reverse", new ReverseFilter());
 *     controller(ReverseFilterExample.class);
 *     ...
 *   }
 * }</pre>
 * @author kyoken74
 */
public class ReverseFilterExampleController implements Controller {

    public static final String DEMO_URL =
            ReverseFilterExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String HTML_CONTENT = SafeHtmlUtils.htmlEscape(
            ReverseFilterExampleResources.INSTANCE.html().getText());
    public static final String JAVA_CONTENT = SafeHtmlUtils.htmlEscape(
            ReverseFilterExampleResources.INSTANCE.java().getText());

    private String caption = "Hello, World!";

    @Override
    public void onControllerLoad() {
    }
    
    public String getCaption() {
        return caption;
    }
}

class ReverseFilter extends AbstractFilter {

    @Override
    public String filter(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(input.length());
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }
}

interface ReverseFilterExampleResources extends ClientBundle {

    static final ReverseFilterExampleResources INSTANCE = GWT.create(ReverseFilterExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("ReverseFilterExampleDemo.html")
    public DataResource demo();

    @Source("ReverseFilterExampleDemo.html")
    public TextResource html();
    
    @Source("ReverseFilterExampleController.java")
    public TextResource java();
}