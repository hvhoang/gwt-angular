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
		$ value = get("data");
		return value == null ? null : value.<T>cast();
	}
	
	public final $ getHeader() {
		$ value = get("header");
		return value == null ? null : value.<T>cast();
	}

	public final $ getConfig() {
		$ value = get("config");
		return value == null ? null : value.<T>cast();
	}

}