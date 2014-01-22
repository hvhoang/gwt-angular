package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Module;
import com.asayama.gwt.angular.client.Provider;
import com.asayama.gwt.angular.client.route.Redirect;
import com.asayama.gwt.angular.client.route.Route;
import com.asayama.gwt.angular.client.route.RouteProvider;

public class MyModule extends Module {
	
	protected MyController myController;
	protected RouteProvider routeProvider;
	
	@Override
	public void onProviderReady(Provider provider) {
		if (provider == routeProvider) {
			routeProvider
				.when("/hello", Route.templateUrl("app/partials/hello.html"))
				.otherwise(Redirect.redirectTo("/hello"));
		}
	}
}
