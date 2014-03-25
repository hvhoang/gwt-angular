package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class TextInputExampleController implements Controller {

    public static final String DEMO_URL =
            TextInputExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String HTML_CONTENT = SafeHtmlUtils.htmlEscape(
            TextInputExampleResources.INSTANCE.html().getText());
    public static final String JAVA_CONTENT = SafeHtmlUtils.htmlEscape(
            TextInputExampleResources.INSTANCE.java().getText());

    @Override
    public void onControllerLoad() {
    }
}

interface TextInputExampleResources extends ClientBundle {
    
    static final TextInputExampleResources INSTANCE = GWT.create(TextInputExampleResources.class);

    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/TextInputDemo.html")
    public DataResource demo();
    
    @Source("demo/TextInputDemo.html")
    public TextResource html();
    
    @Source("demo/TextInputDemoController.java")
    public TextResource java();
}