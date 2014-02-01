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
	
	final native $ get(String key) /*-{
		try {
			return this[key]||null;
		} catch (e) {
			console.log(e);
		}
	}-*/;
	
	protected final <T extends $> T $object(String key) {
		$ value = get(key);
		return value == null ? null : value.<T>cast();
	}
		
	final native $ put(String key, $ value) /*-{
		try {
			this[key] = value;
		} catch (e) {
			console.log(e);
		}
		return this;
	}-*/;
	
	protected final native String $string(String key) /*-{
		try {
			return this[key]||null;
		} catch (e) {
			console.log(e);
		}
	}-*/;
	
	protected final native Integer $integer(String key) /*-{
		try {
			return this[key] ? this[key] : this[key] == 0 ? 0 : null;
		} catch (e) {
			console.log(e);
		}
	}-*/;
	
	protected final native Double $double(String key) /*-{
		try {
			return this[key] ? this[key] : this[key] == 0.0 ? 0.0 : null;
		} catch (e) {
			console.log(e);
		}
	}-*/;
	
	protected final native Boolean $boolean(String key) /*-{
		try {
			return this[key];
		} catch (e) {
			console.log(e);
		}
	}-*/;
	
	protected final Long $long(String key) {
		String value = $string(key);
		return value == null ? null : new Long(value);
	}
	
	protected final Date $date(String key) {
		Long value = $long(key);
		return value == null ? null : new Date(value);
	}
	
	protected final <T extends $> T $object(String key, $ value) {
		put(key, value);
		return this.<T>cast();
	}

	protected final native <T extends $> T $string(String key, String value) /*-{
		try {
			this[key] = value;
		} catch (e) {
			console.log(e);
		}
		return this;
	}-*/;

	protected final native <T extends $> T $integer(String key, Integer value) /*-{
		try {
			this[key] = value;
		} catch (e) {
			console.log(e);
		}
		return this;
	}-*/;
	
	protected final native <T extends $> T $double(String key, Double value) /*-{
		try {
			this[key] = value;
		} catch (e) {
			console.log(e);
		}
	}-*/;

	protected final native <T extends $> T $boolean(String key, Boolean value) /*-{
		try {
			this[key] = value;
		} catch (e) {
			console.log(e);
		}
	}-*/;
	
	protected final <T extends $> T $long(String key, Long value) {
		$string(key, value == null ? null : value.toString());
		return this.<T>cast();
	}

	protected final <T extends $> T $date(String key, Date value) {
		$long(key, value == null ? null : value.getTime());
		return this.<T>cast();
	}

}
