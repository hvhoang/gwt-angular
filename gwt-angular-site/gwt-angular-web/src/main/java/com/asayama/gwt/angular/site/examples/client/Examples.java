package com.asayama.gwt.angular.site.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.site.pages.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.core.client.EntryPoint;

public class Examples extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("examples", getPages());
        bundle(CustomDirectiveExampleResources.class);
        bundle(CustomFilterExampleResources.class);
        bundle(GwtWidgetsExampleResources.class);

        controller(HttpClientExampleController.class);
        controller(ImageResourceExampleController.class);
        controller(OnClickEventExampleController.class);
        controller(PrettifyExampleController.class);
        controller(PromiseExampleController.class);
        controller(TextInputExampleController.class);
        controller(UrlHashParameterExampleController.class);
    }
    
    private JSArray<Page> getPages() {
        JSArray<Page> pages = JSArray.create();
        pages.add(Page.create("Text Input", TextInputExampleResources.INSTANCE.textInput()));
        pages.add(Page.create("OnClick Event", OnClickEventExampleResources.INSTANCE.onClickEvent()));
        pages.add(Page.create("Custom Directive", CustomDirectiveExampleResources.INSTANCE.customDirective()));
        pages.add(Page.create("Custom Filter", CustomFilterExampleResources.INSTANCE.customFilter()));
        pages.add(Page.create("Promise", PromiseExampleResources.INSTANCE.promise()));
        pages.add(Page.create("Image Resource", ImageResourceExampleResources.INSTANCE.imageResource()));
        pages.add(Page.create("URL Hash Parameter", UrlHashParameterExampleResources.INSTANCE.urlHashParameter()));
        pages.add(Page.create("HTTP Client", HttpClientExampleResources.INSTANCE.httpClient()));
        pages.add(Page.create("GWT Widgets", GwtWidgetsExampleResources.INSTANCE.gwtWidgets()));
        pages.add(Page.create("Prettify", PrettifyExampleResources.INSTANCE.prettify()));
       return pages;
    }
}

