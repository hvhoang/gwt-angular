package com.asayama.gwt.core.client;

import com.google.gwt.core.client.JavaScriptObject;

public class $ extends JavaScriptObject {

	public static native $ create() /*-{
		return {};
	}-*/;
	
	protected $() {
	}
	
	public final native $ get(String key) /*-{
		return this[key];
	}-*/;
	
	public final native $ set(String key, $ value) /*-{
		this[key] = value;
		return this;
	}-*/;
}
