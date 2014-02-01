package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Creator;
import com.asayama.gwt.angular.client.Provider;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class MyEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		GWT.log("entering MyEntryPoint.onModuleLoad");
		MyModule myModule = GWT.create(MyModule.class);
		Angular.bootstrap(myModule);
		
		ProviderCreator<?> fc = GWT.create(ProviderCreator.class);
	}

}
interface ProviderCreator<T extends Provider> extends Creator<T> {
	@Override
	public T create(Class<? extends T> klass);
}