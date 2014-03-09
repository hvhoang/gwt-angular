package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.route.client.Redirect;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.angular.route.client.Template;
import com.google.gwt.core.client.EntryPoint;

public class DemoEntryPoint extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        constant("examplesURL", "examples.json");
        constant("downloadsURL", "https://api.github.com/repos/kyoken74/gwt-angular/tags");
        controller(new DocumentationController());
        controller(new DownloadsController());
        controller(new ExamplesController());
        controller(new JumbotronController());
        controller(new NavbarController());
        controller(new NavigationController());
        config(new RouteProvider(), new Configurator<RouteProvider>() {
            @Override
            public void configure(RouteProvider routeProvider) {
                routeProvider
                    .when("/documentation", Template.create("partials/documentation.html", DocumentationController.class))
                    .when("/downloads", Template.create("partials/downloads.html", DownloadsController.class))
                    .when("/examples", Template.create("partials/examples.html", ExamplesController.class))
                    .when("/jumbotron", Template.create("partials/jumbotron.html", JumbotronController.class))
                    .otherwise(Redirect.create("/jumbotron"));
            }
        });
        Angular.bootstrap();
    }
}
