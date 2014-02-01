package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.route.RouteParams;
import com.asayama.gwt.angular.client.route.RouteProvider;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class MyEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		GWT.log("entering MyEntryPoint.onModuleLoad");
		
//		MyModule myModule = GWT.create(MyModule.class);
		
		MyModule myModule = Angular.module(new MyModule());
		myModule.config(RouteProvider.class);
		myModule.factory(RouteParams.class);
		//myModule.factory(Q.class);
		myModule.controller(MyController.class);
		
		Angular.bootstrap(myModule);
	}

}
