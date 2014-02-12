package com.asayama.demo.client;

import com.asayama.demo.client.controller.Example1Controller;
import com.asayama.demo.client.controller.Example2Controller;
import com.asayama.demo.client.controller.Example3Controller;
import com.asayama.demo.client.controller.Example4Controller;
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
				.when("/example1", Template.create("partials/panels/example1.html", Example1Controller.class))
				.when("/example2", Template.create("partials/panels/example2.html", Example2Controller.class))
				.when("/example3", Template.create("partials/panels/example3.html", Example3Controller.class))
				.when("/example4", Template.create("partials/panels/example4.html", Example4Controller.class))
				.otherwise(Redirect.create("/example1"));
		}
	}

}
