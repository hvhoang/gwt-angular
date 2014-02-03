package com.asayama.gwt.core.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public interface Function<R extends JavaScriptObject> {
	R function(JsArray<?> jsarray);
}
