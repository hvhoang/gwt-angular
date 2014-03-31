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
import com.asayama.gwt.core.client.JSArray;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;


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
    public static final String TEXT_INPUT_VIEW_CONTENT = SafeHtmlUtils.htmlEscape(
            TextInputExampleResources.INSTANCE.view().getText());
    public static final String TEXT_INPUT_CONTROLLER_CONTENT = SafeHtmlUtils.htmlEscape(
            TextInputExampleResources.INSTANCE.controller().getText());
    
    // OnClick Example Resources
    public static final String ONCLICK_VIEW_CONTENT = SafeHtmlUtils.htmlEscape(
            OnClickEventExampleResources.INSTANCE.view().getText());
    public static final String ONCLICK_CONTROLLER_CONTENT = SafeHtmlUtils.htmlEscape(
            OnClickEventExampleResources.INSTANCE.controller().getText());

    // Reverse Filter Example Resources
    public static final String REVERSE_FILTER_VIEW_CONTENT = SafeHtmlUtils.htmlEscape(
            ReverseFilterExampleResources.INSTANCE.view().getText());
    public static final String REVERSE_FILTER_CONTROLLER_CONTENT = SafeHtmlUtils.htmlEscape(
            ReverseFilterExampleResources.INSTANCE.controller().getText());
    public static final String REVERSE_FILTER_FILTER_CONTENT = SafeHtmlUtils.htmlEscape(
            ReverseFilterExampleResources.INSTANCE.filter().getText());
    public static final String REVERSE_FILTER_MODULE_CONTENT = SafeHtmlUtils.htmlEscape(
            ReverseFilterExampleResources.INSTANCE.module().getText());

    // URL Hash Parameter Example Resources
    public static final String URL_HASH_PARAMETER_VIEW_CONTENT = SafeHtmlUtils.htmlEscape(
            UrlHashParameterExampleResources.INSTANCE.view().getText());
    public static final String URL_HASH_PARAMETER_CONTROLLER_CONTENT = SafeHtmlUtils.htmlEscape(
            UrlHashParameterExampleResources.INSTANCE.controller().getText());

    // HttpClient Example Resources
    public static final String HTTP_CLIENT_VIEW_CONTENT = SafeHtmlUtils.htmlEscape(
            HttpClientExampleResources.INSTANCE.view().getText());
    public static final String HTTP_CLIENT_CONTROLLER_CONTENT = SafeHtmlUtils.htmlEscape(
            HttpClientExampleResources.INSTANCE.controller().getText());

    // Prettify Example Resources
    public static final String PRETTIFY_VIEW_CONTENT = SafeHtmlUtils.htmlEscape(
            PrettifyExampleResources.INSTANCE.view().getText());
    public static final String PRETTIFY_CONTROLLER_CONTENT = SafeHtmlUtils.htmlEscape(
            PrettifyExampleResources.INSTANCE.controller().getText());

    // Custome Directive Example Resources
    public static final String CUSTOM_DIRECTIVE_VIEW_CONTENT = SafeHtmlUtils.htmlEscape(
            CustomDirectiveExampleResources.INSTANCE.view().getText());
    public static final String CUSTOM_DIRECTIVE_CONTROLLER_CONTENT = SafeHtmlUtils.htmlEscape(
            CustomDirectiveExampleResources.INSTANCE.controller().getText());
    public static final String CUSTOM_DIRECTIVE_DIRECTIVE_CONTENT = SafeHtmlUtils.htmlEscape(
            CustomDirectiveExampleResources.INSTANCE.directive().getText());
    public static final String CUSTOM_DIRECTIVE_TEMPLATE_CONTENT = SafeHtmlUtils.htmlEscape(
            CustomDirectiveExampleResources.INSTANCE.template().getText());
    public static final String CUSTOM_DIRECTIVE_MODULE_CONTENT = SafeHtmlUtils.htmlEscape(
            CustomDirectiveExampleResources.INSTANCE.module().getText());
    
    
    
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
