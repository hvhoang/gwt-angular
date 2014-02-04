package com.asayama.gwt.core.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public interface Function<R extends JavaScriptObject> {

	/**
	 * @deprecated To be replaced with something ike R function(Object... args)
	 */
	R function(JsArray<?> jsarray);
}
