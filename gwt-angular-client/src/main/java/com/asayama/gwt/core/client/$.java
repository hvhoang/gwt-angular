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
	
	public final <T extends $> T getObject(String key) {
		$ value = get(key);
		return value == null ? null : value.<T>cast();
	}
		
	final native $ get(String key) /*-{
		try {
			return this[key]||null;
		} catch (e) {
			console.log(e);
		}
	}-*/;
	
	public final native String getString(String key) /*-{
		try {
			return this[key]||null;
		} catch (e) {
			console.log(e);
		}
	}-*/;
	
	public final native Integer getInteger(String key) /*-{
		try {
			return this[key]||null;
		} catch (e) {
			console.log(e);
		}
	}-*/;
	
	public final Long getLong(String key) {
		String value = getString(key);
		return value == null ? null : new Long(value);
	}
	
	public final Date getDate(String key) {
		Long value = getLong(key);
		return value == null ? null : new Date(value);
	}
	
	public final native <T extends $> T set(String key, $ value) /*-{
		try {
			this[key] = value;
		} catch (e) {
			console.log(e);
		}
		return this;
	}-*/;

	public final native <T extends $> T setString(String key, String value) /*-{
		try {
			this[key] = value;
		} catch (e) {
			console.log(e);
		}
		return this;
	}-*/;

	public final native <T extends $> T setInteger(String key, Integer value) /*-{
		try {
			this[key] = value;
		} catch (e) {
			console.log(e);
		}
		return this;
	}-*/;

	public final <T extends $> T setLong(String key, Long value) {
		setString(key, value == null ? null : value.toString());
		return this.<T>cast();
	}

	public final <T extends $> T setDate(String key, Date value) {
		setLong(key, value == null ? null : value.getTime());
		return this.<T>cast();
	}

}
