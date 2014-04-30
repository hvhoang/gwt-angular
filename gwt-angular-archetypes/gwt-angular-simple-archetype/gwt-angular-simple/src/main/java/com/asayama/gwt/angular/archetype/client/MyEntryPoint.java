package com.asayama.gwt.angular.archetype.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Configurator;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.google.gwt.core.client.EntryPoint;

public class MyEntryPoint extends AbstractModule implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Angular.module(this);
        config(RouteProvider.class, new Configurator<RouteProvider>() {
            @Override
            public void configure(RouteProvider provider) {
                provider
                    .when(MyResources.INSTANCE.MyView(), MyController.class)
                    .otherwise(MyResources.INSTANCE.MyView());
            }
        });
		Angular.bootstrap();
	}
}
