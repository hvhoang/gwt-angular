package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.examples.client.model.Page;
import com.asayama.gwt.angular.examples.client.model.Pages;
import com.asayama.gwt.angular.examples.client.partials.ExamplesPartials;
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
    
    private Pages getPages() {
        Pages pages = Pages.create();
        pages.put("textInput", Page.create("Text Input",
                ExamplesPartials.INSTANCE.textInput().getSafeUri().asString()));
        pages.put("onClickEvent", Page.create("OnClick Event",
                ExamplesPartials.INSTANCE.onClickEvent().getSafeUri().asString()));
        pages.put("reverseFilter", Page.create("Reverse Filter",
                ExamplesPartials.INSTANCE.reverseFilter().getSafeUri().asString()));
        pages.put("urlHashParameter", Page.create("URL Hash Parameter",
                ExamplesPartials.INSTANCE.urlHashParameter().getSafeUri().asString()));
        pages.put("httpClient", Page.create("HTTP Client",
                ExamplesPartials.INSTANCE.httpClient().getSafeUri().asString()));
        pages.put("prettify", Page.create("Prettify",
                ExamplesPartials.INSTANCE.prettify().getSafeUri().asString()));
       return pages;
    }
}

