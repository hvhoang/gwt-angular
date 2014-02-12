package com.asayama.demo.client;

import com.asayama.demo.client.controller.ContainerController;
import com.asayama.demo.client.controller.Example1Controller;
import com.asayama.demo.client.controller.Example2Controller;
import com.asayama.demo.client.controller.Example3Controller;
import com.asayama.demo.client.controller.Example4Controller;
import com.asayama.demo.client.controller.NavbarController;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.asayama.gwt.angular.route.client.RouteProvider;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class MyEntryPoint implements EntryPoint {

	public void onModuleLoad() {

		GWT.log("entering MyEntryPoint.onModuleLoad");

		final MyModule myModule = Angular.module(MyModule.class);
		myModule.config(RouteProvider.class);
		myModule.factory(Q.class);
		myModule.factory(HttpClient.class);
		myModule.factory(RouteParams.class);
		myModule.factory(Location.class);
		myModule.controller(NavbarController.class);
		myModule.controller(ContainerController.class);
		myModule.controller(Example1Controller.class);
		myModule.controller(Example2Controller.class);
		myModule.controller(Example3Controller.class);
		myModule.controller(Example4Controller.class);
		Angular.bootstrap(myModule);
	}
}
