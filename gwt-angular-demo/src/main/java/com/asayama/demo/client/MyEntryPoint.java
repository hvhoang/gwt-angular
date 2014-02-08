package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Scope;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.angular.http.client.Http;
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
		myModule.factory(Http.class);
		myModule.factory(Scope.class);
		myModule.factory(RouteParams.class);
		myModule.factory(Location.class);
		myModule.controller(MyController.class);
		
		Angular.bootstrap(myModule);
	}

}
