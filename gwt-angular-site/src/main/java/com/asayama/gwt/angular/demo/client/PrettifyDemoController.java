package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;


public class PrettifyDemoController implements Controller {

    public static final String HTML_CONTENT = SafeHtmlUtils.htmlEscape(
            PrettifyExampleResources.INSTANCE.demoHtml().getText());
//    public static final TextResource HTML = 
//            PrettifyExampleResources.INSTANCE.demoHtml();

    @Override
    public void onControllerLoad() {
        //noop
    }
}

interface PrettifyExampleResources extends ClientBundle {

    static final PrettifyExampleResources INSTANCE =
            GWT.create(PrettifyExampleResources.class);
    
    @Source("com/asayama/gwt/angular/demo/client/view/PrettifyDemo.html")
    TextResource demoHtml();
}