package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.demo.client.partials.Partials;
import com.asayama.gwt.angular.route.client.Redirect;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.angular.route.client.Template;
import com.google.gwt.core.client.EntryPoint;

public class DemoEntryPoint extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        controller(DocumentationController.class);
        controller(DownloadsController.class);
        controller(ExamplesController.class);
        controller(JumbotronController.class);
        controller(NavbarController.class);
        config(RouteProvider.class, new Configurator<RouteProvider>() {
            @Override
            public void configure(RouteProvider routeProvider) {
                routeProvider
                    .when("/documentation", Template.create(Partials.INSTANCE.documentation(), DocumentationController.class))
                    .when("/downloads", Template.create(Partials.INSTANCE.downloads(), DownloadsController.class))
                    .when("/examples", Template.create(Partials.INSTANCE.examples(), ExamplesController.class))
                    .when("/jumbotron", Template.create(Partials.INSTANCE.jumbotron(), JumbotronController.class))
                    .otherwise(Redirect.create("/jumbotron"));
            }
        });
        Angular.bootstrap();
    }
}
