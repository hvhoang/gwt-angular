package com.asayama.gwt.core.client;

public interface Function<R extends JSObject, T extends JSObject> {
	R function(T jso);
}
