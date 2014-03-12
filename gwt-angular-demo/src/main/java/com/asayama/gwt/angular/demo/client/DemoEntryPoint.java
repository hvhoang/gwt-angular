package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.demo.client.model.Page;
import com.asayama.gwt.angular.route.client.Redirect;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.angular.route.client.Template;
import com.asayama.gwt.core.client.JSArray;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class DemoEntryPoint extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        
        JSArray<Page> pages = JSArray.eval(DemoResources.INSTANCE.config().getText());
        
        Angular.module(this);
        constant("pages", pages);
        constant("examplesURL", "examples.json");
        constant("downloadsURL", "https://api.github.com/repos/kyoken74/gwt-angular/tags");
        controller(DocumentationController.class);
        controller(DownloadsController.class);
        controller(ExamplesController.class);
        controller(JumbotronController.class);
        controller(NavbarController.class);
        controller(NavbarController.class);
        config(RouteProvider.class, new Configurator<RouteProvider>() {
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

interface DemoResources extends ClientBundle {

    public static final DemoResources INSTANCE = GWT.create(DemoResources.class);

    @Source("config.json")
    public TextResource config();
}