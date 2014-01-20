package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Angular;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class MyEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		GWT.log("entering MyEntryPoint.onModuleLoad");
		MyModule myModule = GWT.create(MyModule.class);
		Angular.bootstrap(MyModule.class.getName());
	}

}
