package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.angular.util.client.AbstractMultiPageController;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.core.client.JSArray;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;


public class ExamplesController extends AbstractMultiPageController {

    // Text Input Example
    public static final String TEXT_INPUT_DEMO_URL =
            TextInputExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String TEXT_INPUT_VIEW_CONTENT = SafeHtmlUtils.htmlEscape(
            TextInputExampleResources.INSTANCE.view().getText());
    public static final String TEXT_INPUT_CONTROLLER_CONTENT = SafeHtmlUtils.htmlEscape(
            TextInputExampleResources.INSTANCE.controller().getText());
    
    // OnClick Example
    public static final String ONCLICK_DEMO_URL =
            OnClickEventExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String ONCLICK_VIEW_CONTENT = SafeHtmlUtils.htmlEscape(
            OnClickEventExampleResources.INSTANCE.view().getText());
    public static final String ONCLICK_CONTROLLER_CONTENT = SafeHtmlUtils.htmlEscape(
            OnClickEventExampleResources.INSTANCE.controller().getText());

    // Reverse Filter Example
    public static final String REVERSE_FILTER_DEMO_URL =
            ReverseFilterExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String REVERSE_FILTER_VIEW_CONTENT = SafeHtmlUtils.htmlEscape(
            ReverseFilterExampleResources.INSTANCE.view().getText());
    public static final String REVERSE_FILTER_CONTROLLER_CONTENT = SafeHtmlUtils.htmlEscape(
            ReverseFilterExampleResources.INSTANCE.controller().getText());
    public static final String REVERSE_FILTER_FILTER_CONTENT = SafeHtmlUtils.htmlEscape(
            ReverseFilterExampleResources.INSTANCE.filter().getText());
    public static final String REVERSE_FILTER_MODULE_CONTENT = SafeHtmlUtils.htmlEscape(
            ReverseFilterExampleResources.INSTANCE.module().getText());

    // URL Hash Parameter Example
    public static final String URL_HASH_PARAMETER_DEMO_URL =
            UrlHashParameterExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String URL_HASH_PARAMETER_VIEW_CONTENT = SafeHtmlUtils.htmlEscape(
            UrlHashParameterExampleResources.INSTANCE.view().getText());
    public static final String URL_HASH_PARAMETER_CONTROLLER_CONTENT = SafeHtmlUtils.htmlEscape(
            UrlHashParameterExampleResources.INSTANCE.controller().getText());

    // HttpClient Example
    public static final String HTTP_CLIENT_DEMO_URL =
            HttpClientExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String HTTP_CLIENT_VIEW_CONTENT = SafeHtmlUtils.htmlEscape(
            HttpClientExampleResources.INSTANCE.view().getText());
    public static final String HTTP_CLIENT_CONTROLLER_CONTENT = SafeHtmlUtils.htmlEscape(
            HttpClientExampleResources.INSTANCE.controller().getText());

    // Prettify Example
    public static final String PRETTIFY_DEMO_URL =
            PrettifyExampleResources.INSTANCE.demo().getSafeUri().asString();
    public static final String PRETTIFY_VIEW_CONTENT = SafeHtmlUtils.htmlEscape(
            PrettifyExampleResources.INSTANCE.html().getText());
    public static final String PRETTIFY_CONTROLLER_CONTENT = SafeHtmlUtils.htmlEscape(
            PrettifyExampleResources.INSTANCE.java().getText());


    @Bind("examples")
    private JSArray<Page> pages = null;
    private String defaultPageName = null;
    
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

interface HttpClientExampleResources extends ClientBundle {

    static final HttpClientExampleResources INSTANCE = GWT.create(HttpClientExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/HttpClientDemo.html")
    public DataResource demo();

    @Source("demo/HttpClientDemo.html")
    public TextResource view();
    
    @Source("demo/HttpClientDemoController.java")
    public TextResource controller();
}

interface OnClickEventExampleResources extends ClientBundle {

    static final OnClickEventExampleResources INSTANCE = GWT.create(OnClickEventExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/OnClickEventDemo.html")
    public DataResource demo();

    @Source("demo/OnClickEventDemo.html")
    public TextResource view();
    
    @Source("demo/OnClickEventDemoController.java")
    public TextResource controller();
}

interface ReverseFilterExampleResources extends ClientBundle {

    static final ReverseFilterExampleResources INSTANCE = GWT.create(ReverseFilterExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/ReverseFilterDemo.html")
    public DataResource demo();

    @Source("demo/ReverseFilterDemo.html")
    public TextResource view();
    
    @Source("demo/ReverseFilterDemoController.java")
    public TextResource controller();

    @Source("demo/ReverseFilter.java")
    public TextResource filter();

    @Source("demo/ReverseFilterModule.txt")
    public TextResource module();
}

interface TextInputExampleResources extends ClientBundle {
    
    static final TextInputExampleResources INSTANCE = GWT.create(TextInputExampleResources.class);

    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/TextInputDemo.html")
    public DataResource demo();
    
    @Source("demo/TextInputDemo.html")
    public TextResource view();
    
    @Source("demo/TextInputDemoController.java")
    public TextResource controller();
}

interface UrlHashParameterExampleResources extends ClientBundle {

    static final UrlHashParameterExampleResources INSTANCE = GWT.create(UrlHashParameterExampleResources.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("demo/UrlHashParameterDemo.html")
    public DataResource demo();

    @Source("demo/UrlHashParameterDemo.html")
    public TextResource view();
    
    @Source("demo/UrlHashParameterDemoController.java")
    public TextResource controller();
}
