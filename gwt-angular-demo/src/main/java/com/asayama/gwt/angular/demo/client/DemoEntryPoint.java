package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.examples.client.ExamplesController;
import com.asayama.gwt.angular.examples.client.ExamplesPartials;
import com.asayama.gwt.angular.route.client.Redirect;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.angular.route.client.Template;
import com.asayama.gwt.angular.tutorial.client.TutorialController;
import com.asayama.gwt.angular.tutorial.client.TutorialPartials;
import com.google.gwt.core.client.EntryPoint;

public class DemoEntryPoint extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        controller(DocumentationController.class);
        controller(DownloadsController.class);
        controller(JumbotronController.class);
        controller(NavbarController.class);
        config(RouteProvider.class, new Configurator<RouteProvider>() {
            @Override
            public void configure(RouteProvider routeProvider) {
                routeProvider
                    .when("/documentation", Template.create(DemoPartials.INSTANCE.documentation(), DocumentationController.class))
                    .when("/downloads", Template.create(DemoPartials.INSTANCE.downloads(), DownloadsController.class))
                    .when("/examples", Template.create(ExamplesPartials.INSTANCE.examples(), ExamplesController.class))
                    .when("/jumbotron", Template.create(DemoPartials.INSTANCE.jumbotron(), JumbotronController.class))
                    .when("/tutorial", Template.create(TutorialPartials.INSTANCE.tutorial(), TutorialController.class))
                    .otherwise(Redirect.create("/jumbotron"));
            }
        });
        Angular.bootstrap();
    }
}
