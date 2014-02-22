package com.asayama.demo.client;

import com.asayama.demo.client.examples.TextInputExample;
import com.asayama.demo.client.examples.OnClickEventExample;
import com.asayama.demo.client.examples.UrlHashParameterExample;
import com.asayama.demo.client.examples.HttpClientExample;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.client.log.Log;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class MyEntryPoint implements EntryPoint {

    public void onModuleLoad() {
        GWT.log("entering MyEntryPoint.onModuleLoad");
        MyModule myModule = Angular.module(new MyModule());
        myModule.config(new RouteProvider());
        myModule.factory(new Q());
        myModule.factory(new HttpClient());
        myModule.factory(new RouteParams());
        myModule.factory(new Location());
        myModule.factory(new Log());
        myModule.controller(new NavbarController());
        myModule.controller(new ExamplesController());
        myModule.controller(new TextInputExample());
        myModule.controller(new OnClickEventExample());
        myModule.controller(new UrlHashParameterExample());
        myModule.controller(new HttpClientExample());
        Angular.bootstrap(myModule);
    }
}
