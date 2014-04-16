package com.asayama.gwt.angular.site.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.client.location.LocationProvider;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.google.gwt.core.client.EntryPoint;

public class SiteEntryPoint extends AbstractModule implements EntryPoint {

    public void onModuleLoad() {
        Angular.module(this);
        controller(DocumentationController.class);
        controller(DownloadsController.class);
        controller(ExamplesController.class);
        controller(JumbotronController.class);
        controller(NavbarController.class);
        controller(TutorialController.class);
        config(LocationProvider.class, new Configurator<LocationProvider>() {
            public void configure(LocationProvider provider) {
                provider.hashPrefix("!");
            }
        });
        config(RouteProvider.class, new Configurator<RouteProvider>() {
            @Override
            public void configure(RouteProvider provider) {
                provider
                    .when(SiteResources.INSTANCE.documentation(), DocumentationController.class)
                    .when(SiteResources.INSTANCE.downloads(), DownloadsController.class)
                    .when(SiteResources.INSTANCE.jumbotron(), JumbotronController.class)
                    .when(SiteResources.INSTANCE.examples(), ExamplesController.class)
                    .when(SiteResources.INSTANCE.tutorial(), TutorialController.class)
                    .otherwise(SiteResources.INSTANCE.jumbotron());
            }
        });
        Angular.bootstrap();
    }
}
