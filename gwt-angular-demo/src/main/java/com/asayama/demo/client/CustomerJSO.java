package com.asayama.demo.client;

import com.google.gwt.core.client.JavaScriptObject;

public class CustomerJSO extends JavaScriptObject {

	protected CustomerJSO() {
	}
	
	public final native String getName() /*={
		return this.name;
	}-*/;
	
	public final native CustomerJSO setName(String name) /*-{
		this.name = name;
		return this;
	}-*/;
	
	public final native String getCity() /*={
		return this.city;
	}-*/;
	
	public final native CustomerJSO setCity(String city) /*-{
		this.city = city;
		return this;
	}-*/;
}
