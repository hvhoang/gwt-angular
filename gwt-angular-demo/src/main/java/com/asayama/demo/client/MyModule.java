package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Injectable;
import com.asayama.gwt.angular.client.Module;
import com.asayama.gwt.angular.client.route.Redirect;
import com.asayama.gwt.angular.client.route.Route;
import com.asayama.gwt.angular.client.route.RouteProvider;
import com.google.gwt.core.client.GWT;

public class MyModule extends Module {
	
	protected RouteProvider routeProvider;
	protected MyController myController;
	
	@Override
	public void onInjection(Injectable object) {
		if (object == routeProvider) {
			GWT.log("routeProvider injected");
			routeProvider
				.when("/hello", Route.create("partials/hello.html", MyController.class))
				.otherwise(Redirect.create("/hello"));
		}
	}
}
