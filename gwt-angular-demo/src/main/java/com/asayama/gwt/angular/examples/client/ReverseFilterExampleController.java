package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;


public class ReverseFilterExampleController implements Controller {

    public static final String DEMO_URL =
            ReverseFilterExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String HTML_CONTENT = SafeHtmlUtils.htmlEscape(
            ReverseFilterExampleResources.INSTANCE.html().getText());
    public static final String JAVA_CONTENT = SafeHtmlUtils.htmlEscape(
            ReverseFilterExampleResources.INSTANCE.java().getText());

    @Override
    public void onControllerLoad() {
    }
}

interface ReverseFilterExampleResources extends ClientBundle {

    static final ReverseFilterExampleResources INSTANCE = GWT.create(ReverseFilterExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/ReverseFilterDemo.html")
    public DataResource demo();

    @Source("demo/ReverseFilterDemo.html")
    public TextResource html();
    
    @Source("demo/ReverseFilterDemoController.java")
    public TextResource java();

    @Source("demo/ReverseFilter.java")
    public TextResource filter();
}