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
		return this[key]||null;
	}-*/;
	
	public final native String getString(String key) /*-{
		return this[key]||null;
	}-*/;
	
	public final native $ set(String key, $ value) /*-{
		this[key] = value;
		return this;
	}-*/;

	public final native $ setString(String key, String value) /*-{
		this[key] = value;
		return this;
	}-*/;
}
