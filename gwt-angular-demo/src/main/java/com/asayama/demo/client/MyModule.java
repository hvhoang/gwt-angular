package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Injectable;
import com.asayama.gwt.angular.client.Module;
import com.asayama.gwt.angular.client.annotations.Depends;
import com.asayama.gwt.angular.route.client.Redirect;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.asayama.gwt.angular.route.client.Template;

@Depends(ng = { "ngRoute", "ngSanitize" })
public class MyModule extends Module {
	
	@Override
	public void onInjection(Injectable object) {
		if (object instanceof RouteProvider) {
			((RouteProvider) object)
				.when("/hello", Template.create("partials/hello.html", MyController.class))
				.otherwise(Redirect.create("/hello"));
		}
	}

}