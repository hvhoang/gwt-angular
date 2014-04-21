package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.Controller;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


public class PrettifyDemoController implements Controller {

    public static final TextResource VIEW_CODE = MyResources.INSTANCE.demoHtml();

    @Override
    public void onControllerLoad() {
        //noop
    }
}

interface MyResources extends ClientBundle {

    static final MyResources INSTANCE = GWT.create(MyResources.class);
    
    @Source("view/PrettifyDemo.html")
    TextResource demoHtml();
}