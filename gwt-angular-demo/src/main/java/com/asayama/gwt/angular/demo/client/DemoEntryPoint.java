package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.client.TemplateDirective;
import com.asayama.gwt.angular.examples.client.partials.TextInputExampleResources;
import com.asayama.gwt.angular.examples.client.partials.UrlHashParameterExampleResources;
import com.asayama.gwt.angular.route.client.Redirect;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.angular.route.client.Template;
import com.google.gwt.core.client.EntryPoint;

public class DemoEntryPoint extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        
        // TODO Can I genericise this directive? Some kind of HtmlResourceDirective to take TextResource?
        directive("myTextInputExample", new TemplateDirective(TextInputExampleResources.INSTANCE.html()));
        directive("myUrlHashParameterExample", new TemplateDirective(UrlHashParameterExampleResources.INSTANCE.html()));
        
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