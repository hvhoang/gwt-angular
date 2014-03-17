package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.core.client.JSON;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class ExamplesModule extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("Pages.json", JSON.parse(ExamplesResources.INSTANCE.pages().getText()));
        filter("reverse", new ReverseFilter());
        controller(HttpClientExampleController.class);
        controller(OnClickEventExampleController.class);
        controller(PrettifyExampleController.class);
        controller(TextInputExampleController.class);
        controller(UrlHashParameterExampleController.class);
        controller(ReverseFilterExampleController.class);
    }
}

interface ExamplesResources extends ClientBundle {
    
    public static final ExamplesResources INSTANCE = GWT.create(ExamplesResources.class);

    @Source("Pages.json")
    public TextResource pages();
}