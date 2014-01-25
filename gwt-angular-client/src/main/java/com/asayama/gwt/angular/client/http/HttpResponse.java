package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.core.client.$;

public class HttpResponse<T extends $> extends $ {

	protected HttpResponse() {
	}

	public final int getStatus() {
		Integer value = getInteger("status");
		return value == null ? 0 : value.intValue();
	}
	
	public final T getData() {
		$ value = getObject("data");
		return value == null ? null : value.<T>cast();
	}
	
	//TODO Implement a proper HttpHeader type extending $
	public final $ getHeader() {
		$ value = getObject("header");
		return value == null ? null : value.<$>cast();
	}

	//TODO Implement a proper HttpConfig type extending $
	public final $ getConfig() {
		$ value = getObject("config");
		return value == null ? null : value.<$>cast();
	}

}