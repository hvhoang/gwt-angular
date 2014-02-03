package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Injectable;
import com.asayama.gwt.angular.client.Module;
import com.asayama.gwt.angular.client.annotations.Depends;
import com.asayama.gwt.angular.client.route.Redirect;
import com.asayama.gwt.angular.client.route.RouteProvider;
import com.asayama.gwt.angular.client.route.Template;

@Depends({ "ngRoute", "ngSanitize" })
public class MyModule extends Module {

	@Override
	public void onInjection(Injectable object) {
		if (object instanceof RouteProvider) {
			((RouteProvider) object)
				.when("/hello", Template.create("partials/hello.html", MyController.class))
				.when("/hello/:name", Template.create("partials/hello.html", MyController.class))
				.otherwise(Redirect.create("/hello"));
		}
	}

}