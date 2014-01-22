package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.JS;

public interface HttpCallback<T extends JS> {
	void onSuccess(HttpResponse<T> response);
	void onError(HttpResponse<T> response);
}
