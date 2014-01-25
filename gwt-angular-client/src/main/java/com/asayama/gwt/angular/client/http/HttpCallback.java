package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.core.client.$;

/**
 * This class is unsupported.
 */
@Deprecated
public interface HttpCallback<T extends $> {
	void onSuccess(HttpResponse<T> response);
	void onError(HttpResponse<T> response);
}
