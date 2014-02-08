package com.asayama.gwt.core.client;

import java.util.Date;

import com.asayama.gwt.core.client.exceptions.EmptyKeyException;
import com.asayama.gwt.core.client.exceptions.UndefinedException;
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
public class JSObject extends JavaScriptObject {

	public static native <T extends JSObject> T create() /*-{
		return {};
	}-*/;
	
	public static <T extends JSObject> T parse(String jsonString) {
		return JsonUtils.safeEval(jsonString).cast();
	}
	
	public static <R extends JSObject, P extends JSObject> R cast(P object) {
		if (object == null) {
			return null;
		}
		return object.cast();
	}
	
	protected JSObject() {
	}

	protected final native boolean _isThisUndefined() /*-{
		return (typeof(this) == "undefined");
	}-*/;

	protected final void _checkUndefined() throws UndefinedException {
		if (_isThisUndefined()) {
			throw new UndefinedException();
		}
	}
	
	protected final void _checkEmptyKey(String key) throws EmptyKeyException {
		if (key == null || key.length() == 0) {
			throw new EmptyKeyException();
		}
	}
	
	/*
	 * Object
	 */

	protected final <T extends JSObject> T getObject(String key) throws UndefinedException, EmptyKeyException {
		_checkUndefined();
		_checkEmptyKey(key);
		JSObject value = _getObject(key);
		return value == null ? null : value.<T>cast();
	}
	
	private final native JSObject _getObject(String key) /*-{
		return typeof(this[key]) == "undefined" ? null : this[key];
	}-*/;
	
	protected final <T extends JSObject> void putObject(String key, T value) throws UndefinedException, EmptyKeyException {
		_checkUndefined();
		_checkEmptyKey(key);
		value._checkUndefined();
		_putObject(key, value);
	}
	
	private final native void _putObject(String key, JSObject value) /*-{
		this[key] = value;
	}-*/;

	/*
	 * String
	 */
	
	protected final String getString(String key) throws UndefinedException, EmptyKeyException {
		_checkUndefined();
		_checkEmptyKey(key);
		String value = _getString(key);
		return value == null ? null : value;
	}
	
	private final native String _getString(String key) /*-{
		return typeof(this[key]) == "undefined" ? null : this[key];
	}-*/;
	
	protected final void putString(String key, String value) throws UndefinedException, EmptyKeyException {
		_checkUndefined();
		_checkEmptyKey(key);
		_putString(key, value);
	}
	
	private final native void _putString(String key, String value) /*-{
		this[key] = value;
	}-*/;

	/*
	 * Integer
	 */
	
	protected final Integer getInteger(String key) throws UndefinedException, EmptyKeyException {
		_checkUndefined();
		_checkEmptyKey(key);
		Integer value = _getInteger(key);
		return value == null ? null : value;
	}
	
	private final native Integer _getInteger(String key) /*-{
		return typeof(this[key]) == "undefined" ? null : this[key];
	}-*/;
	
	protected final void putInteger(String key, Integer value) throws UndefinedException, EmptyKeyException {
		_checkUndefined();
		_checkEmptyKey(key);
		_putInteger(key, value);
	}
	
	private final native void _putInteger(String key, Integer value) /*-{
		this[key] = value;
	}-*/;

	/*
	 * Double
	 */
	
	protected final Double getDouble(String key) throws UndefinedException, EmptyKeyException {
		_checkUndefined();
		_checkEmptyKey(key);
		Double value = _getDouble(key);
		return value == null ? null : value;
	}
	
	private final native Double _getDouble(String key) /*-{
		return typeof(this[key]) == "undefined" ? null : this[key];
	}-*/;

	protected final void putDouble(String key, Double value) throws UndefinedException, EmptyKeyException {
		_checkUndefined();
		_checkEmptyKey(key);
		_putDouble(key, value);
	}
	
	private final native void _putDouble(String key, Double value) /*-{
		this[key] = value;
	}-*/;

	/*
	 * Boolean
	 */
	
	protected final Boolean getBoolean(String key) throws UndefinedException, EmptyKeyException {
		_checkUndefined();
		_checkEmptyKey(key);
		Boolean value = _getBoolean(key);
		return value == null ? null : value;
	}

	private final native Boolean _getBoolean(String key) /*-{
		return typeof(this[key]) == "undefined" ? null : this[key];
	}-*/;
	
	protected final void putBoolean(String key, Boolean value) throws UndefinedException, EmptyKeyException {
		_checkUndefined();
		_checkEmptyKey(key);
		_putBoolean(key, value);
	}
	
	private final native void _putBoolean(String key, Boolean value) /*-{
		this[key] = value;
	}-*/;

	/*
	 * Long
	 */
	
	protected final Long getLong(String key) throws UndefinedException, EmptyKeyException {
		String value = getString(key);
		return value == null ? null : Long.valueOf(value);
	}

	protected final void putLong(String key, Long value) throws UndefinedException, EmptyKeyException {
		putString(key, value+"");
	}

	/*
	 * Date
	 */
	
	protected final Date getDate(String key) throws UndefinedException, EmptyKeyException {
		Long value = getLong(key);
		return value == null ? null : new Date(value);
	}

	protected final void putDate(String key, Date value) throws UndefinedException, EmptyKeyException {
		putLong(key, value.getTime());
	}
	
}
