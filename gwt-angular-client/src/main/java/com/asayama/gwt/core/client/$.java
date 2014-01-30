package com.asayama.gwt.core.client;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;

/**
 * Represents a JavaScriptObject, and used as a syntax sugar, i.e. a shorthand
 * for its direct parent.
 * 
 * @author kyoken74
 * @see Function
 * @see Invoker
 */
public class $ extends JavaScriptObject {

	public static native <T extends $> T create() /*-{
		return {};
	}-*/;
	
	public static <T extends $> T parse(String jsonString) {
		return JsonUtils.safeEval(jsonString).cast();
	}
	
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
			return this[key] ? this[key] : this[key] == 0 ? 0 : null;
		} catch (e) {
			console.log(e);
		}
	}-*/;
	
	public final native Double getDouble(String key) /*-{
		try {
			return this[key] ? this[key] : this[key] == 0.0 ? 0.0 : null;
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
	
	public final <T extends $> T putObject(String key, $ value) {
		put(key, value);
		return this.<T>cast();
	}

	final native $ put(String key, $ value) /*-{
		try {
			this[key] = value;
		} catch (e) {
			console.log(e);
		}
		return this;
	}-*/;

	public final native <T extends $> T putString(String key, String value) /*-{
		try {
			this[key] = value;
		} catch (e) {
			console.log(e);
		}
		return this;
	}-*/;

	public final native <T extends $> T putInteger(String key, Integer value) /*-{
		try {
			this[key] = value;
		} catch (e) {
			console.log(e);
		}
		return this;
	}-*/;

	public final <T extends $> T putLong(String key, Long value) {
		putString(key, value == null ? null : value.toString());
		return this.<T>cast();
	}

	public final <T extends $> T putDate(String key, Date value) {
		putLong(key, value == null ? null : value.getTime());
		return this.<T>cast();
	}

}
