package com.asayama.demo.client;

import com.asayama.demo.shared.Customer;
import com.google.gwt.core.client.JavaScriptObject;

public class CustomerJSO extends JavaScriptObject implements Customer {

	protected CustomerJSO() {
	}
	
	@Override
	public final native String getName() /*={
		return this.name;
	}-*/;
	
	@Override
	public final native Customer setName(String name) /*-{
		this.name = name;
		return this;
	}-*/;
	
	@Override
	public final native String getCity() /*={
		return this.city;
	}-*/;
	
	@Override
	public final native Customer setCity(String city) /*-{
		this.city = city;
		return this;
	}-*/;
}
