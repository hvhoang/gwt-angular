package com.asayama.gwt.angular.examples.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.core.client.JSON;
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
    
    public native JSON getPages() /*-{
        return {
            "textInput" : {
                "title" : "Text Input",
                "filename" : "partials/examples/TextInputExample.html"
            },
            "onClickEvent" : {
                "title" : "OnClick Event",
                "filename" : "partials/examples/OnClickEventExample.html"
            },
            "urlHashParameter" : {
                "title" : "URL Hash Parameter",
                "filename" : "partials/examples/UrlHashParameterExample.html"
            },
            "httpClient" : {
                "title" : "HTTP Client",
                "filename" : "partials/examples/HttpClientExample.html"
            },
            "reverseFilter" : {
                "title" : "Reverse Filter",
                "filename" : "partials/examples/ReverseFilterExample.html"
            },
            "prettify" : {
                "title" : "google-code-prettify",
                "filename" : "partials/examples/PrettifyExample.html"
            }
        };
    }-*/;
}