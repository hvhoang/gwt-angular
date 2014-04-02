package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.examples.client.ExamplesResources.CustomDirectiveExampleResources;
import com.asayama.gwt.angular.examples.client.ExamplesResources.HttpClientExampleResources;
import com.asayama.gwt.angular.examples.client.ExamplesResources.OnClickEventExampleResources;
import com.asayama.gwt.angular.examples.client.ExamplesResources.PrettifyExampleResources;
import com.asayama.gwt.angular.examples.client.ExamplesResources.ReverseFilterExampleResources;
import com.asayama.gwt.angular.examples.client.ExamplesResources.TextInputExampleResources;
import com.asayama.gwt.angular.examples.client.ExamplesResources.UrlHashParameterExampleResources;
import com.asayama.gwt.angular.examples.client.view.demo.ExamplesDemoPartials;
import com.asayama.gwt.angular.util.client.AbstractMultiPageController;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.resources.client.TextResource;


public class ExamplesController extends AbstractMultiPageController {

    // Partials
    public static final String TEXT_INPUT_DEMO_URL =
            ExamplesDemoPartials.INSTANCE.textInput().url();
    public static final String ONCLICK_DEMO_URL =
            ExamplesDemoPartials.INSTANCE.onClickEvent().url();
    public static final String REVERSE_FILTER_DEMO_URL =
            ExamplesDemoPartials.INSTANCE.reverseFilter().url();
    public static final String CUSTOM_DIRECTIVE_DEMO_URL =
            ExamplesDemoPartials.INSTANCE.customDirectiveExample().url();
    public static final String URL_HASH_PARAMETER_DEMO_URL =
            ExamplesDemoPartials.INSTANCE.urlHashParameter().url();
    public static final String HTTP_CLIENT_DEMO_URL =
            ExamplesDemoPartials.INSTANCE.httpClient().url();
    public static final String PRETTIFY_DEMO_URL =
            ExamplesDemoPartials.INSTANCE.prettify().url();
    
    // Text Input Example Resources
    public static final TextResource TEXT_INPUT_VIEW = TextInputExampleResources.INSTANCE.view();
    public static final TextResource TEXT_INPUT_CONTROLLER = TextInputExampleResources.INSTANCE.controller();
    
    // OnClick Example Resources
    public static final TextResource ONCLICK_VIEW = OnClickEventExampleResources.INSTANCE.view();
    public static final TextResource ONCLICK_CONTROLLER = OnClickEventExampleResources.INSTANCE.controller();

    // Reverse Filter Example Resources
    public static final TextResource REVERSE_FILTER_VIEW = ReverseFilterExampleResources.INSTANCE.view();
    public static final TextResource REVERSE_FILTER_CONTROLLER = ReverseFilterExampleResources.INSTANCE.controller();
    public static final TextResource REVERSE_FILTER_FILTER = ReverseFilterExampleResources.INSTANCE.filter();
    public static final TextResource REVERSE_FILTER_MODULE = ReverseFilterExampleResources.INSTANCE.module();

    // Custome Directive Example Resources
    public static final TextResource CUSTOM_DIRECTIVE_VIEW = CustomDirectiveExampleResources.INSTANCE.view();
    public static final TextResource CUSTOM_DIRECTIVE_CONTROLLER = CustomDirectiveExampleResources.INSTANCE.controller();
    public static final TextResource CUSTOM_DIRECTIVE_DIRECTIVE = CustomDirectiveExampleResources.INSTANCE.directive();
    public static final TextResource CUSTOM_DIRECTIVE_TEMPLATE = CustomDirectiveExampleResources.INSTANCE.template();
    public static final TextResource CUSTOM_DIRECTIVE_MODULE = CustomDirectiveExampleResources.INSTANCE.module();

    // URL Hash Parameter Example Resources
    public static final TextResource URL_HASH_PARAMETER_VIEW = UrlHashParameterExampleResources.INSTANCE.view();
    public static final TextResource URL_HASH_PARAMETER_CONTROLLER = UrlHashParameterExampleResources.INSTANCE.controller();

    // HttpClient Example Resources
    public static final TextResource HTTP_CLIENT_VIEW = HttpClientExampleResources.INSTANCE.view();
    public static final TextResource HTTP_CLIENT_CONTROLLER = HttpClientExampleResources.INSTANCE.controller();

    // Prettify Example Resources
    public static final TextResource PRETTIFY_VIEW = PrettifyExampleResources.INSTANCE.view();
    public static final TextResource PRETTIFY_CONTROLLER = PrettifyExampleResources.INSTANCE.controller();

    
    
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
