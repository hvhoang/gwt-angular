package com.asayama.demo.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.route.client.Redirect;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.angular.route.client.Template;
import com.asayama.gwt.core.client.Config;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class DemoEntryPoint extends AbstractModule implements EntryPoint {

    Config config = JSObject.eval("$wnd.config");

    public void onModuleLoad() {
        GWT.log("initializing " + getClass().getName());
        Angular.module(this);
        value("config", config);
        constant("hostPageBaseURL", GWT.getModuleBaseForStaticFiles());
        config(new RouteProvider(), new Configurator<RouteProvider>() {
            @Override
            public void configure(RouteProvider routeProvider) {
                routeProvider
                    .when("/examples", Template.create("partials/examples.html", ExamplesController.class))
                    .otherwise(Redirect.create("/examples"));
            }
        });
        controller(new NavbarController());
        controller(new ExamplesController());
        Angular.bootstrap();
    }
}
