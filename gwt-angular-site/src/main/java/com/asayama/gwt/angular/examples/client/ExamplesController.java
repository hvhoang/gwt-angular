package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.demo.client.DemoResources;
import com.asayama.gwt.angular.util.client.AbstractMultiPageController;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.resources.client.TextResource;


public class ExamplesController extends AbstractMultiPageController {

    // Partials
    public static final String ONCLICK_DEMO_URL = DemoResources.INSTANCE.onClickEvent().getSafeUri().asString();
    public static final String CUSTOM_FILTER_DEMO_URL = DemoResources.INSTANCE.reverseFilter().getSafeUri().asString();
    public static final String CUSTOM_DIRECTIVE_DEMO_URL = DemoResources.INSTANCE.customDirectiveExample().getSafeUri().asString();
    public static final String URL_HASH_PARAMETER_DEMO_URL = DemoResources.INSTANCE.urlHashParameter().getSafeUri().asString();
    public static final String HTTP_CLIENT_DEMO_URL = DemoResources.INSTANCE.httpClient().getSafeUri().asString();
    public static final String PRETTIFY_DEMO_URL = DemoResources.INSTANCE.prettify().getSafeUri().asString();
    
    // OnClick Example Resources
    public static final TextResource ONCLICK_VIEW = DemoResources.INSTANCE.onClickEventResources().view();
    public static final TextResource ONCLICK_CONTROLLER = DemoResources.INSTANCE.onClickEventResources().controller();

    // Reverse Filter Example Resources
    public static final TextResource CUSTOM_FILTER_VIEW = DemoResources.INSTANCE.customFilterResources().view();
    public static final TextResource CUSTOM_FILTER_CONTROLLER = DemoResources.INSTANCE.customFilterResources().controller();
    public static final TextResource CUSTOM_FILTER_FILTER = DemoResources.INSTANCE.customFilterResources().filter();
    public static final TextResource CUSTOM_FILTER_MODULE = DemoResources.INSTANCE.customFilterResources().module();

    // Custome Directive Example Resources
    public static final TextResource CUSTOM_DIRECTIVE_VIEW = DemoResources.INSTANCE.customDirectiveResources().view();
    public static final TextResource CUSTOM_DIRECTIVE_CONTROLLER = DemoResources.INSTANCE.customDirectiveResources().controller();
    public static final TextResource CUSTOM_DIRECTIVE_DIRECTIVE = DemoResources.INSTANCE.customDirectiveResources().directive();
    public static final TextResource CUSTOM_DIRECTIVE_TEMPLATE = DemoResources.INSTANCE.customDirectiveResources().template();
    public static final TextResource CUSTOM_DIRECTIVE_MODULE = DemoResources.INSTANCE.customDirectiveResources().module();

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
