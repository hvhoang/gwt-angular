package com.asayama.gwt.core.client;

import java.util.Date;

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
	
	public final native Integer getInteger(String key) /*-{
		return this[key]||null;
	}-*/;
	
	public final Long getLong(String key) {
		String value = getString(key);
		return value == null ? null : new Long(value);
	}
	
	public final Date getDate(String key) {
		Long value = getLong(key);
		return value == null ? null : new Date(value);
	}
	
	public final native $ set(String key, $ value) /*-{
		this[key] = value;
		return this;
	}-*/;

	public final native $ setString(String key, String value) /*-{
		this[key] = value;
		return this;
	}-*/;

	public final native $ setInteger(String key, Integer value) /*-{
		this[key] = value;
		return this;
	}-*/;

	public final $ setLong(String key, Long value) {
		setString(key, value == null ? null : value.toString());
		return this;
	}

	public final $ setDate(String key, Date value) {
		setLong(key, value == null ? null : value.getTime());
		return this;
	}

}
