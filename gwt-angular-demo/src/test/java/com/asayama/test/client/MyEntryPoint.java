package com.asayama.test.client;

import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;

public class MyEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		MyModule myModule = Angular.module(MyModule.class);
		myModule.controller(MyController.class);
		Angular.bootstrap(myModule);
	}

}
