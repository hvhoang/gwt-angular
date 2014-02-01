package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.core.client.JSObject;

public class HttpResponse<T extends JSObject> extends JSObject {

	protected HttpResponse() {
	}

	public final int getStatus() {
		Integer value = getInteger("status");
		return value == null ? 0 : value.intValue();
	}
	
	public final T getData() {
		JSObject value = getObject("data");
		return value == null ? null : value.<T>cast();
	}
	
	//TODO Implement a proper HttpHeader type extending $
	public final JSObject getHeader() {
		JSObject value = getObject("header");
		return value == null ? null : value.<JSObject>cast();
	}

	//TODO Implement a proper HttpConfig type extending $
	public final JSObject getConfig() {
		JSObject value = getObject("config");
		return value == null ? null : value.<JSObject>cast();
	}

}