package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
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

    public static final String SOURCE = SafeHtmlUtils.htmlEscape(
            PrettifyExampleResources.INSTANCE.source().getText());
    
    @Override
    public void onControllerLoad() {
    }
    
}

interface PrettifyExampleResources extends ClientBundle {
    
    public static final PrettifyExampleResources INSTANCE = GWT.create(PrettifyExampleResources.class);

    @Source("PrettifyExampleController.java")
    public TextResource source();
}