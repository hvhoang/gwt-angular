package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

public class OnClickEventExampleController implements Controller {

    public static final String DEMO_URL =
            OnClickEventExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String HTML_CONTENT = SafeHtmlUtils.htmlEscape(
            OnClickEventExampleResources.INSTANCE.html().getText());
    public static final String JAVA_CONTENT = SafeHtmlUtils.htmlEscape(
            OnClickEventExampleResources.INSTANCE.java().getText());

    @Override
    public void onControllerLoad() {
    }
}

interface OnClickEventExampleResources extends ClientBundle {

    static final OnClickEventExampleResources INSTANCE = GWT.create(OnClickEventExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("OnClickEventDemo.html")
    public DataResource demo();

    @Source("OnClickEventDemo.html")
    public TextResource html();
    
    @Source("OnClickEventDemoController.java")
    public TextResource java();
}
