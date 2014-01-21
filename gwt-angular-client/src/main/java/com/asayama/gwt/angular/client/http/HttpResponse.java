package com.asayama.gwt.angular.client.http;

import com.google.gwt.core.client.JavaScriptObject;

public interface HttpResponse<T extends JavaScriptObject> {

	int getStatus();
	T getData();
	
}
class HttpResponseJSO<T extends JavaScriptObject> extends JavaScriptObject implements HttpResponse<T> {

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