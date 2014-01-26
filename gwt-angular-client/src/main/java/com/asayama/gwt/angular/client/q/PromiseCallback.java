package com.asayama.gwt.angular.client.q;

public interface PromiseCallback {
	void onSuccess();
	void onError();
	void onSignal();
}
