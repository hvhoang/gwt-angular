package com.asayama.gwt.angular.client.http;

public interface HttpCallback {

	public void onSuccess(int status, String data);
	public void onError(int status, String data);

}
