package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.examples.client.demo.HttpClientDemoController;
import com.asayama.gwt.angular.examples.client.demo.OnClickEventDemoController;
import com.asayama.gwt.angular.examples.client.demo.PrettifyDemoController;
import com.asayama.gwt.angular.examples.client.demo.ReverseFilter;
import com.asayama.gwt.angular.examples.client.demo.ReverseFilterDemoController;
import com.asayama.gwt.angular.examples.client.demo.TextInputDemoController;
import com.asayama.gwt.angular.examples.client.demo.UrlHashParameterDemoController;
import com.asayama.gwt.angular.examples.client.view.ExamplesPartials;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.core.client.JSArray;
import com.google.gwt.core.client.EntryPoint;

public class ExamplesModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("examples", getPages());
        filter("reverse", new ReverseFilter());
        controller(ExamplesController.class);
        controller(HttpClientDemoController.class);
        controller(OnClickEventDemoController.class);
        controller(TextInputDemoController.class);
        controller(UrlHashParameterDemoController.class);
        controller(ReverseFilterDemoController.class);
        controller(PrettifyDemoController.class);
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

