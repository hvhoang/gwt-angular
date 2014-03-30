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
import com.asayama.gwt.angular.examples.client.directive.Hello;
import com.asayama.gwt.angular.examples.client.filter.ReverseFilter;
import com.asayama.gwt.angular.examples.client.view.docs.ExamplesDocsPartials;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.core.client.JSArray;
import com.google.gwt.core.client.EntryPoint;

public class ExamplesModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("examples", getPages());
        directive("my", new Hello());
        filter("reverse", new ReverseFilter());
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
                ExamplesDocsPartials.INSTANCE.textInput()));
        pages.add(Page.create("OnClick Event",
                ExamplesDocsPartials.INSTANCE.onClickEvent()));
        pages.add(Page.create("Reverse Filter",
                ExamplesDocsPartials.INSTANCE.reverseFilter()));
//        pages.add(Page.create("Custom Directive",
//                ExamplesDocsPartials.INSTANCE.customDirective()));
        pages.add(Page.create("URL Hash Parameter",
                ExamplesDocsPartials.INSTANCE.urlHashParameter()));
        pages.add(Page.create("HTTP Client",
                ExamplesDocsPartials.INSTANCE.httpClient()));
        pages.add(Page.create("Prettify",
                ExamplesDocsPartials.INSTANCE.prettify()));
       return pages;
    }
}

