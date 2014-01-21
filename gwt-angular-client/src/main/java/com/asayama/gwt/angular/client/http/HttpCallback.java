package com.asayama.gwt.angular.client.http;

import com.google.gwt.core.client.JavaScriptObject;

public interface HttpCallback<T extends JavaScriptObject> {
	void onSuccess(int status, T data);
	void onError(int status, T data);
}
