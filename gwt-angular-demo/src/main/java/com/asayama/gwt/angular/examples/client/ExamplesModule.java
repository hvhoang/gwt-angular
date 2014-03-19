package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.examples.client.model.Page;
import com.asayama.gwt.angular.examples.client.model.Pages;
import com.asayama.gwt.angular.examples.client.partials.Partials;
import com.google.gwt.core.client.EntryPoint;

public class ExamplesModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("Pages.json", getPages());
        filter("reverse", new ReverseFilter());
        controller(HttpClientExampleController.class);
        controller(OnClickEventExampleController.class);
        controller(PrettifyExampleController.class);
        controller(TextInputExampleController.class);
        controller(UrlHashParameterExampleController.class);
        controller(ReverseFilterExampleController.class);
    }
    
    private Pages getPages() {
        Pages pages = Pages.create();
        pages.put("textInput", Page.create("Text Input",
                Partials.INSTANCE.textInput().getSafeUri().asString()));
        pages.put("onClickEvent", Page.create("OnClick Event",
                Partials.INSTANCE.onClickEvent().getSafeUri().asString()));
        pages.put("reverseFilter", Page.create("Reverse Filter",
                Partials.INSTANCE.reverseFilter().getSafeUri().asString()));
        pages.put("urlHashParameter", Page.create("URL Hash Parameter",
                Partials.INSTANCE.urlHashParameter().getSafeUri().asString()));
        pages.put("httpClient", Page.create("HTTP Client",
                Partials.INSTANCE.httpClient().getSafeUri().asString()));
        pages.put("prettify", Page.create("Prettify",
                Partials.INSTANCE.prettify().getSafeUri().asString()));
       return pages;
    }
}

