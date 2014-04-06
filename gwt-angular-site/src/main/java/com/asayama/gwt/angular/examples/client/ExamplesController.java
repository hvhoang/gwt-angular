package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.demo.client.DemoResources;
import com.asayama.gwt.angular.util.client.AbstractMultiPageController;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.resources.client.TextResource;


public class ExamplesController extends AbstractMultiPageController {

    // Partials
    public static final String URL_HASH_PARAMETER_DEMO_URL = DemoResources.INSTANCE.urlHashParameter().getSafeUri().asString();
    public static final String HTTP_CLIENT_DEMO_URL = DemoResources.INSTANCE.httpClient().getSafeUri().asString();
    public static final String PRETTIFY_DEMO_URL = DemoResources.INSTANCE.prettify().getSafeUri().asString();
    
    // URL Hash Parameter Example Resources
    public static final TextResource URL_HASH_PARAMETER_VIEW = DemoResources.INSTANCE.urlHashParameterResources().view();
    public static final TextResource URL_HASH_PARAMETER_CONTROLLER = DemoResources.INSTANCE.urlHashParameterResources().controller();

    // HttpClient Example Resources
    public static final TextResource HTTP_CLIENT_VIEW = DemoResources.INSTANCE.httpClientResources().view();
    public static final TextResource HTTP_CLIENT_CONTROLLER = DemoResources.INSTANCE.httpClientResources().controller();

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
