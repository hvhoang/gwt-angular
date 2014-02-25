package com.asayama.demo.client;

import com.asayama.demo.client.examples.HttpClientExample;
import com.asayama.demo.client.examples.OnClickEventExample;
import com.asayama.demo.client.examples.TextInputExample;
import com.asayama.demo.client.examples.UrlHashParameterExample;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.InjectionCallback;
import com.asayama.gwt.angular.client.Module;
import com.asayama.gwt.angular.route.client.Redirect;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.angular.route.client.Template;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class MyModule extends Module implements EntryPoint {

    public void onModuleLoad() {
        GWT.log("entering MyModule.onModuleLoad");
        Angular.module(this);
        config(new RouteProvider(), new InjectionCallback<RouteProvider>() {
            @Override
            public void onInjection(RouteProvider routeProvider) {
                routeProvider
                    .when("/examples", Template.create("partials/examples.html", ExamplesController.class))
                    .otherwise(Redirect.create("/examples"));
            }
        });
        controller(new NavbarController());
        controller(new ExamplesController());
        controller(new TextInputExample());
        controller(new OnClickEventExample());
        controller(new UrlHashParameterExample());
        controller(new HttpClientExample());
        Angular.bootstrap();
    }
}
