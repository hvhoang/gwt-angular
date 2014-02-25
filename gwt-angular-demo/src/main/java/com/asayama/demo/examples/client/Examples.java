package com.asayama.demo.examples.client;

import com.asayama.demo.examples.client.controllers.HttpClientExample;
import com.asayama.demo.examples.client.controllers.OnClickEventExample;
import com.asayama.demo.examples.client.controllers.TextInputExample;
import com.asayama.demo.examples.client.controllers.UrlHashParameterExample;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Module;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class Examples extends Module implements EntryPoint {

    public void onModuleLoad() {
        GWT.log("initializing " + getClass().getName());
        Angular.module(this);
        controller(new HttpClientExample());
        controller(new OnClickEventExample());
        controller(new TextInputExample());
        controller(new UrlHashParameterExample());
    }
}
