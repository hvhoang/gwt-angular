package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;
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

    @Override
    public void onControllerLoad() {
    }
    
}

interface PrettifyExampleResources extends ClientBundle {

    static final PrettifyExampleResources INSTANCE = GWT.create(PrettifyExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/PrettifyDemo.html")
    public DataResource demo();

    @Source("demo/PrettifyDemo.html")
    public TextResource html();
    
    @Source("PrettifyExampleController.java")
    public TextResource java();
}
