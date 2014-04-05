package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.examples.client.view.demo.ExamplesDemoResources;
import com.asayama.gwt.angular.util.client.AbstractMultiPageController;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.resources.client.TextResource;


public class ExamplesController extends AbstractMultiPageController {

    // Partials
    public static final String TEXT_INPUT_DEMO_URL = ExamplesDemoResources.INSTANCE.textInput().getSafeUri().asString();
    public static final String ONCLICK_DEMO_URL = ExamplesDemoResources.INSTANCE.onClickEvent().getSafeUri().asString();
    public static final String REVERSE_FILTER_DEMO_URL = ExamplesDemoResources.INSTANCE.reverseFilter().getSafeUri().asString();
    public static final String CUSTOM_DIRECTIVE_DEMO_URL = ExamplesDemoResources.INSTANCE.customDirectiveExample().getSafeUri().asString();
    public static final String URL_HASH_PARAMETER_DEMO_URL = ExamplesDemoResources.INSTANCE.urlHashParameter().getSafeUri().asString();
    public static final String HTTP_CLIENT_DEMO_URL = ExamplesDemoResources.INSTANCE.httpClient().getSafeUri().asString();
    public static final String PRETTIFY_DEMO_URL = ExamplesDemoResources.INSTANCE.prettify().getSafeUri().asString();
    
    // Text Input Example Resources
    public static final TextResource TEXT_INPUT_VIEW = ExamplesResources.INSTANCE.textInput().view();
    public static final TextResource TEXT_INPUT_CONTROLLER = ExamplesResources.INSTANCE.textInput().controller();
    
    // OnClick Example Resources
    public static final TextResource ONCLICK_VIEW = ExamplesResources.INSTANCE.onClickEvent().view();
    public static final TextResource ONCLICK_CONTROLLER = ExamplesResources.INSTANCE.onClickEvent().controller();

    // Reverse Filter Example Resources
    public static final TextResource REVERSE_FILTER_VIEW = ExamplesResources.INSTANCE.reverseFilter().view();
    public static final TextResource REVERSE_FILTER_CONTROLLER = ExamplesResources.INSTANCE.reverseFilter().controller();
    public static final TextResource REVERSE_FILTER_FILTER = ExamplesResources.INSTANCE.reverseFilter().filter();
    public static final TextResource REVERSE_FILTER_MODULE = ExamplesResources.INSTANCE.reverseFilter().module();

    // Custome Directive Example Resources
    public static final TextResource CUSTOM_DIRECTIVE_VIEW = ExamplesResources.INSTANCE.customDirective().view();
    public static final TextResource CUSTOM_DIRECTIVE_CONTROLLER = ExamplesResources.INSTANCE.customDirective().controller();
    public static final TextResource CUSTOM_DIRECTIVE_DIRECTIVE = ExamplesResources.INSTANCE.customDirective().directive();
    public static final TextResource CUSTOM_DIRECTIVE_TEMPLATE = ExamplesResources.INSTANCE.customDirective().template();
    public static final TextResource CUSTOM_DIRECTIVE_MODULE = ExamplesResources.INSTANCE.customDirective().module();

    // URL Hash Parameter Example Resources
    public static final TextResource URL_HASH_PARAMETER_VIEW = ExamplesResources.INSTANCE.urlHashParameter().view();
    public static final TextResource URL_HASH_PARAMETER_CONTROLLER = ExamplesResources.INSTANCE.urlHashParameter().controller();

    // HttpClient Example Resources
    public static final TextResource HTTP_CLIENT_VIEW = ExamplesResources.INSTANCE.httpClient().view();
    public static final TextResource HTTP_CLIENT_CONTROLLER = ExamplesResources.INSTANCE.httpClient().controller();

    // Prettify Example Resources
    public static final TextResource PRETTIFY_VIEW = ExamplesResources.INSTANCE.prettify().view();
    public static final TextResource PRETTIFY_CONTROLLER = ExamplesResources.INSTANCE.prettify().controller();

    
    
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
