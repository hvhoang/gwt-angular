package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.demo.client.DemoResources;
import com.asayama.gwt.angular.util.client.AbstractMultiPageController;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.resources.client.TextResource;


public class ExamplesController extends AbstractMultiPageController {

    // Partials
    public static final String PRETTIFY_DEMO_URL = DemoResources.INSTANCE.prettify().getSafeUri().asString();
    

    // Prettify Example Resources
    public static final TextResource PRETTIFY_VIEW = DemoResources.INSTANCE.prettifyResources().view();
    public static final TextResource PRETTIFY_CONTROLLER = DemoResources.INSTANCE.prettifyResources().controller();
    
    
    
    @Bind("examples")
    private JSArray<Page> pages = null;
    private String defaultPageName = "textInput";
    
    // Getters and Setters

    @Override
    public JSArray<Page> getPages() {
        return pages;
    }

    @Override
    public void setPages(JSArray<Page> pages) {
        this.pages = pages;
    }
    
    @Override
    public String getDefaultPageName() {
        return defaultPageName;
    }
    
    @Override
    public void setDefaultPageName(String defaultPageName) {
        this.defaultPageName = defaultPageName;
    }
}
