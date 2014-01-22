package com.asayama.gwt.core.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Represents a JavaScriptObject, and used as a syntax sugar, i.e. a shorthand
 * for its direct parent.
 * 
 * @author kyoken74
 * @see Function
 * @see Invoker
 */
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
