package com.asayama.demo.client;

import com.asayama.demo.client.examples.ExampleController0;
import com.asayama.demo.client.examples.ExampleController1;
import com.asayama.demo.client.examples.ExampleController2;
import com.asayama.demo.client.examples.ExampleController3;
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
		MyModule myModule = Angular.module(MyModule.class);
		myModule.config(RouteProvider.class);
		myModule.factory(Q.class);
		myModule.factory(HttpClient.class);
		myModule.factory(RouteParams.class);
		myModule.factory(Location.class);
		myModule.controller(NavbarController.class);
		myModule.controller(ExamplesController.class);
		myModule.controller(ExampleController0.class);
		myModule.controller(ExampleController1.class);
		myModule.controller(ExampleController2.class);
		myModule.controller(ExampleController3.class);
		Angular.bootstrap(myModule);
	}
}
