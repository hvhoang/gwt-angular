package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.core.client.EntryPoint;

public class ExamplesModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("examples", getPages());
        controller(ExamplesController.class);
    }
    
    private JSArray<Page> getPages() {
        JSArray<Page> pages = JSArray.create();
        pages.add(Page.create("Text Input", ExamplesResources.INSTANCE.textInput()));
        pages.add(Page.create("OnClick Event", ExamplesResources.INSTANCE.onClickEvent()));
        pages.add(Page.create("Custom Filter", ExamplesResources.INSTANCE.reverseFilter()));
        pages.add(Page.create("Custom Directive", ExamplesResources.INSTANCE.customDirective()));
        pages.add(Page.create("URL Hash Parameter", ExamplesResources.INSTANCE.urlHashParameter()));
        pages.add(Page.create("HTTP Client", ExamplesResources.INSTANCE.httpClient()));
        pages.add(Page.create("Prettify", ExamplesResources.INSTANCE.prettify()));
       return pages;
    }
}

