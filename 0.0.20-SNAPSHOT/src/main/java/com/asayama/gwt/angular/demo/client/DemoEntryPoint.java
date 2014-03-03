package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.route.client.Redirect;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.angular.route.client.Template;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class DemoEntryPoint extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        GWT.log("initializing " + getClass().getName());
        Angular.module(this);
        constant("examplesURL", "examples.json");
        controller(new NavbarController());
        controller(new ExamplesController());
        config(new RouteProvider(), new Configurator<RouteProvider>() {
            @Override
            public void configure(RouteProvider routeProvider) {
                routeProvider
                    .when("/jumbotron", Template.create("partials/jumbotron.html", ExamplesController.class))
                    .when("/examples", Template.create("partials/examples.html", ExamplesController.class))
                    .otherwise(Redirect.create("/jumbotron"));
            }
        });
        Angular.bootstrap();
    }
}
