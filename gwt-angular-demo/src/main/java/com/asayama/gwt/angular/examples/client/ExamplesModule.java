package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.examples.client.controller.CustomDirectiveExampleController;
import com.asayama.gwt.angular.examples.client.controller.HttpClientExampleController;
import com.asayama.gwt.angular.examples.client.controller.OnClickEventExampleController;
import com.asayama.gwt.angular.examples.client.controller.PrettifyExampleController;
import com.asayama.gwt.angular.examples.client.controller.ReverseFilterExampleController;
import com.asayama.gwt.angular.examples.client.controller.TextInputExampleController;
import com.asayama.gwt.angular.examples.client.controller.UrlHashParameterExampleController;
import com.asayama.gwt.angular.examples.client.directive.MyHello;
import com.asayama.gwt.angular.examples.client.filter.Reverse;
import com.asayama.gwt.angular.examples.client.view.docs.ExamplesDocsResources;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.core.client.EntryPoint;

public class ExamplesModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("examples", getPages());
        directive(MyHello.class);
        filter(Reverse.class);
        controller(ExamplesController.class);
        controller(HttpClientExampleController.class);
        controller(OnClickEventExampleController.class);
        controller(TextInputExampleController.class);
        controller(UrlHashParameterExampleController.class);
        controller(ReverseFilterExampleController.class);
        controller(PrettifyExampleController.class);
        controller(CustomDirectiveExampleController.class);
    }
    
    private JSArray<Page> getPages() {
        JSArray<Page> pages = JSArray.create();
        pages.add(Page.create("Text Input",
                ExamplesDocsResources.INSTANCE.textInput()));
        pages.add(Page.create("OnClick Event",
                ExamplesDocsResources.INSTANCE.onClickEvent()));
        pages.add(Page.create("Custom Filter",
                ExamplesDocsResources.INSTANCE.reverseFilter()));
        pages.add(Page.create("Custom Directive",
                ExamplesDocsResources.INSTANCE.customDirective()));
        pages.add(Page.create("URL Hash Parameter",
                ExamplesDocsResources.INSTANCE.urlHashParameter()));
        pages.add(Page.create("HTTP Client",
                ExamplesDocsResources.INSTANCE.httpClient()));
        pages.add(Page.create("Prettify",
                ExamplesDocsResources.INSTANCE.prettify()));
       return pages;
    }
}

