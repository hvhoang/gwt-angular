package com.asayama.gwt.angular.examples.client.demo;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;


public class PrettifyDemoController implements Controller {

    public static final String HTML_CONTENT = SafeHtmlUtils.htmlEscape(
            PrettifyDemoResources.INSTANCE.demoHtml().getText());
    
    @Override
    public void onControllerLoad() {
        //noop
    }
}

interface PrettifyDemoResources extends ClientBundle {

    static final PrettifyDemoResources INSTANCE =
            GWT.create(PrettifyDemoResources.class);
    
    @Source("PrettifyDemo.html")
    TextResource demoHtml();
}