package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.core.client.JSObject;

public interface HttpCallback<T extends JSObject> {
	void onSuccess(HttpResponse<T> response);
	void onError(HttpResponse<T> response);
}
