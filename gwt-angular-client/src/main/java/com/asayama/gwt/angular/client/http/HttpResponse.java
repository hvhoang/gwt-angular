package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.core.client.$;

public class HttpResponse<T extends $> extends $ {

	protected HttpResponse() {
	}

	public final int getStatus() {
		Integer value = $integer("status");
		return value == null ? 0 : value.intValue();
	}
	
	public final T getData() {
		$ value = $object("data");
		return value == null ? null : value.<T>cast();
	}
	
	//TODO Implement a proper HttpHeader type extending $
	public final $ getHeader() {
		$ value = $object("header");
		return value == null ? null : value.<$>cast();
	}

	//TODO Implement a proper HttpConfig type extending $
	public final $ getConfig() {
		$ value = $object("config");
		return value == null ? null : value.<$>cast();
	}

}