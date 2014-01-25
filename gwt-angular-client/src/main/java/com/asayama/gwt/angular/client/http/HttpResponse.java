package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.core.client.$;

public interface HttpResponse<T extends $> {
	int getStatus();
	T getData();
	$ getHeader();
	$ getConfig();
}
class HttpResponseJSO<T extends $> extends $ implements HttpResponse<T> {

	protected HttpResponseJSO() {
	}

	@Override
	public final int getStatus() {
		Integer value = getInteger("status");
		return value == null ? 0 : value.intValue();
	}
	
	@Override
	public final T getData() {
		$ value = get("data");
		return value == null ? null : value.<T>cast();
	}
	
	@Override
	public final $ getHeader() {
		$ value = get("header");
		return value == null ? null : value.<T>cast();
	}

	@Override
	public final $ getConfig() {
		$ value = get("config");
		return value == null ? null : value.<T>cast();
	}

}