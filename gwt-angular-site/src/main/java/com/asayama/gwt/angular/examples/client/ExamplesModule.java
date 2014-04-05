package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.demo.client.controller.CustomDirectiveExampleController;
import com.asayama.gwt.angular.demo.client.controller.HttpClientExampleController;
import com.asayama.gwt.angular.demo.client.controller.OnClickEventExampleController;
import com.asayama.gwt.angular.demo.client.controller.PrettifyExampleController;
import com.asayama.gwt.angular.demo.client.controller.ReverseFilterExampleController;
import com.asayama.gwt.angular.demo.client.controller.TextInputExampleController;
import com.asayama.gwt.angular.demo.client.controller.UrlHashParameterExampleController;
import com.asayama.gwt.angular.demo.client.directive.MyHello;
import com.asayama.gwt.angular.demo.client.filter.Reverse;
import com.asayama.gwt.angular.examples.client.controller.ExamplesController;
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
                ExamplesResources.INSTANCE.textInput()));
        pages.add(Page.create("OnClick Event",
                ExamplesResources.INSTANCE.onClickEvent()));
        pages.add(Page.create("Custom Filter",
                ExamplesResources.INSTANCE.reverseFilter()));
        pages.add(Page.create("Custom Directive",
                ExamplesResources.INSTANCE.customDirective()));
        pages.add(Page.create("URL Hash Parameter",
                ExamplesResources.INSTANCE.urlHashParameter()));
        pages.add(Page.create("HTTP Client",
                ExamplesResources.INSTANCE.httpClient()));
        pages.add(Page.create("Prettify",
                ExamplesResources.INSTANCE.prettify()));
       return pages;
    }
}

