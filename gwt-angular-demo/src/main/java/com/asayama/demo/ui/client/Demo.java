package com.asayama.demo.ui.client;

import com.asayama.demo.ui.client.controllers.ExamplesController;
import com.asayama.demo.ui.client.controllers.NavbarController;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.route.client.Redirect;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.angular.route.client.Template;
import com.asayama.gwt.core.client.Config;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class Demo extends AbstractModule implements EntryPoint {

    Config config = Config.eval("$wnd.config");

    public void onModuleLoad() {
        GWT.log("initializing " + getClass().getName());
        Angular.module(this);
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
