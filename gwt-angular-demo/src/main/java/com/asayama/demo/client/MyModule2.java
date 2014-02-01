package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Injectable;
import com.asayama.gwt.angular.client.Module;
import com.asayama.gwt.angular.client.route.Redirect;
import com.asayama.gwt.angular.client.route.Route;
import com.asayama.gwt.angular.client.route.RouteProvider;

public class MyModule2 extends Module {

	@Override
	public void onInjection(Injectable object) {
		if (object instanceof RouteProvider) {
			((RouteProvider) object)
				.when("/hello", Route.create("partials/hello.html", MyController.class))
				.when("/hello/:name", Route.create("partials/hello.html", MyController.class))
				.otherwise(Redirect.create("/hello"));
		}
	}

}