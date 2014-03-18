package com.asayama.gwt.angular.demo.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.route.client.Redirect;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.angular.route.client.Template;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.DoNotEmbed;
import com.google.gwt.resources.client.DataResource.MimeType;

public class DemoEntryPoint extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
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

interface Partials extends ClientBundle {
    
    static final Partials INSTANCE = GWT.create(Partials.class);
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("partials/documentation.html")
    public DataResource documentation();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("partials/downloads.html")
    public DataResource downloads();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("partials/examples.html")
    public DataResource examples();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("partials/jumbotron.html")
    public DataResource jumbotron();
    
    @DoNotEmbed
    @MimeType("text/html")
    @Source("partials/navbar.html")
    public DataResource navbar();
    
}