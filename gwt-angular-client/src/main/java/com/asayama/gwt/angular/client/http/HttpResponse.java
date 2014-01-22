package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.JS;

public interface HttpResponse<T extends JS> {

	int getStatus();
	T getData();
	
}
class HttpResponseJSO<T extends JS> extends JS implements HttpResponse<T> {

	protected HttpResponseJSO() {
	}

	@Override
	public final native int getStatus() /*-{
		return this.status;
	}-*/;
	
	@Override
	public final native T getData() /*-{
		return this.data;
	}-*/;

}