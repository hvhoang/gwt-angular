package com.asayama.gwt.core.client;

import com.google.gwt.core.client.JavaScriptObject;


public class JSArray<T> extends JavaScriptObject {

	public static native <T> JSArray<T> create() /*-{
		return [];
	}-*/;

	public static  <T> JSArray<T> create(T... objects) {
		JSArray<T> array = null;
		if (objects != null) {
			array = create();
			for (T object : objects) {
				array.add(object);
			}
		}
		return array;
	}

	protected JSArray() {
	}
	
	public final native void add(T object) /*-{
		this.push(object);
	}-*/;

}
