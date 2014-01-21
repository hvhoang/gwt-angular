package com.asayama.demo.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Customer extends JavaScriptObject {

	protected Customer() {
	}
	
	public final native String getName() /*={
		return this.name;
	}-*/;
	public final native String getCity() /*={
		return this.city;
	}-*/;
}
