package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class UrlHashParameterExampleController implements Controller {

    public static final String DEMO_URL =
            UrlHashParameterExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String HTML_CONTENT = SafeHtmlUtils.htmlEscape(
            UrlHashParameterExampleResources.INSTANCE.html().getText());
    public static final String JAVA_CONTENT = SafeHtmlUtils.htmlEscape(
            UrlHashParameterExampleResources.INSTANCE.java().getText());

    @Override
    public void onControllerLoad() {
    }
}

interface UrlHashParameterExampleResources extends ClientBundle {

    static final UrlHashParameterExampleResources INSTANCE = GWT.create(UrlHashParameterExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("UrlHashParameterDemo.html")
    public DataResource demo();

    @Source("UrlHashParameterDemo.html")
    public TextResource html();
    
    @Source("UrlHashParameterDemoController.java")
    public TextResource java();
}