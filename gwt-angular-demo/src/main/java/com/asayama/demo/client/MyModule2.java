package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Injectable;
import com.asayama.gwt.angular.client.Module;
import com.asayama.gwt.angular.client.route.Redirect;
import com.asayama.gwt.angular.client.route.Route;
import com.asayama.gwt.angular.client.route.RouteProvider;

public class MyModule2 extends Module {

	@Override
	public <T extends Injectable> void onInjection(T object) {
	}
	
	public void onInjection(RouteProvider routeProvider) {
		routeProvider
			.when("/hello", Route.create("partials/hello.html", MyController.class))
			.when("/hello/:name", Route.create("partials/hello.html", MyController.class))
			.otherwise(Redirect.create("/hello"));
	}
}