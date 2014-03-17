package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.examples.client.partials.PrettifyExampleResources;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

/**
 * google-code-prettify GWT Angular filter.
 * <p>
 * Include the following <code>inherits</code> statement in your gwt.xml module
 * descriptor.
 * </p>
 * <pre>{@code 
 * <inherits name="com.asayama.gwt.angular.prettify.PrettifyModule" />
 * }</pre>
 * @author kyoken74
 */
public class PrettifyExampleController implements Controller {

    public static final String DEMO_URL =
            PrettifyExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String HTML_CONTENT = SafeHtmlUtils.htmlEscape(
            PrettifyExampleResources.INSTANCE.html().getText());
    public static final String JAVA_CONTENT = SafeHtmlUtils.htmlEscape(
            PrettifyExampleResources.INSTANCE.java().getText());
    public static final String RESOURCES_CONTENT = SafeHtmlUtils.htmlEscape(
            PrettifyExampleResources.INSTANCE.resources().getText());

    @Override
    public void onControllerLoad() {
    }
    
}
