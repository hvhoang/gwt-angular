package com.asayama.gwt.angular.client;

import com.google.gwt.core.client.JavaScriptObject;

public class JS extends JavaScriptObject {

	public static native JS create() /*-{
		return {};
	}-*/;
	
	protected JS() {
	}
	
	public final native JS get(String key) /*-{
		return this[key];
	}-*/;
	
	public final native JS set(String key, JS value) /*-{
		this[key] = value;
		return this;
	}-*/;
}
