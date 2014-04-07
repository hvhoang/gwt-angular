package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.examples.client.controller.CustomFilterExampleController;
import com.asayama.gwt.angular.examples.client.controller.CustomerDirectiveExampleController;
import com.asayama.gwt.angular.examples.client.controller.HttpClientExampleController;
import com.asayama.gwt.angular.examples.client.controller.ImageResourceExampleController;
import com.asayama.gwt.angular.examples.client.controller.OnClickEventExampleController;
import com.asayama.gwt.angular.examples.client.controller.PrettifyExampleController;
import com.asayama.gwt.angular.examples.client.controller.TextInputExampleController;
import com.asayama.gwt.angular.examples.client.controller.UrlHashParameterExampleController;
import com.asayama.gwt.angular.util.client.Page;
import com.asayama.gwt.jsni.client.JSArray;
import com.google.gwt.core.client.EntryPoint;

public class ExamplesModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("examples", getPages());
        controller(ExamplesController.class);

        controller(CustomerDirectiveExampleController.class);
        controller(CustomFilterExampleController.class);
        controller(HttpClientExampleController.class);
        controller(ImageResourceExampleController.class);
        controller(OnClickEventExampleController.class);
        controller(PrettifyExampleController.class);
        controller(TextInputExampleController.class);
        controller(UrlHashParameterExampleController.class);
    }
    
    private JSArray<Page> getPages() {
        JSArray<Page> pages = JSArray.create();
        pages.add(Page.create("Text Input", ExamplesResources.INSTANCE.textInput()));
        pages.add(Page.create("OnClick Event", ExamplesResources.INSTANCE.onClickEvent()));
        pages.add(Page.create("Custom Filter", ExamplesResources.INSTANCE.customFilter()));
        pages.add(Page.create("Custom Directive", ExamplesResources.INSTANCE.customDirective()));
        pages.add(Page.create("Image Resource", ExamplesResources.INSTANCE.imageSpriting()));
        pages.add(Page.create("URL Hash Parameter", ExamplesResources.INSTANCE.urlHashParameter()));
        pages.add(Page.create("HTTP Client", ExamplesResources.INSTANCE.httpClient()));
        pages.add(Page.create("Prettify", ExamplesResources.INSTANCE.prettify()));
       return pages;
    }
}

