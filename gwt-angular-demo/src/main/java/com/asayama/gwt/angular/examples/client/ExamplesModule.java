package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.examples.client.model.Page;
import com.asayama.gwt.angular.examples.client.partials.ExamplesPartials;
import com.asayama.gwt.core.client.JSArray;
import com.google.gwt.core.client.EntryPoint;

public class ExamplesModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("examples", getPages());
        filter("reverse", new ReverseFilter());
        controller(ExamplesController.class);
        controller(HttpClientExampleController.class);
        controller(HttpClientDemoController.class);
        controller(OnClickEventExampleController.class);
        controller(OnClickEventDemoController.class);
        controller(PrettifyExampleController.class);
        controller(TextInputExampleController.class);
        controller(TextInputDemoController.class);
        controller(UrlHashParameterExampleController.class);
        controller(UrlHashParameterDemoController.class);
        controller(ReverseFilterExampleController.class);
        controller(ReverseFilterDemoController.class);
    }
    
    private JSArray<Page> getPages() {
        JSArray<Page> pages = JSArray.create();
        pages.add(Page.create("Text Input",
                ExamplesPartials.INSTANCE.textInput()));
        pages.add(Page.create("OnClick Event",
                ExamplesPartials.INSTANCE.onClickEvent()));
        pages.add(Page.create("Reverse Filter",
                ExamplesPartials.INSTANCE.reverseFilter()));
        pages.add(Page.create("URL Hash Parameter",
                ExamplesPartials.INSTANCE.urlHashParameter()));
        pages.add(Page.create("HTTP Client",
                ExamplesPartials.INSTANCE.httpClient()));
        pages.add(Page.create("Prettify",
                ExamplesPartials.INSTANCE.prettify()));
       return pages;
    }
}

