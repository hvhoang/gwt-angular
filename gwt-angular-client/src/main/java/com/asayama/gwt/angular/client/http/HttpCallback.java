package com.asayama.gwt.angular.client.http;

import com.google.gwt.core.client.JavaScriptObject;

public interface HttpCallback<T extends JavaScriptObject> {
	void onSuccess(HttpResponse<T> response);
	void onError(HttpResponse<T> response);
}
