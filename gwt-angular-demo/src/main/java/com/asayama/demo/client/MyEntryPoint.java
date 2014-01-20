package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class MyEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		MyModule myModule = GWT.create(MyModule.class);
		Angular.module(myModule);
		MyController myController = GWT.create(MyController.class);
		myModule.controller(myController);
		Angular.bootstrap(myModule);
	}

}
