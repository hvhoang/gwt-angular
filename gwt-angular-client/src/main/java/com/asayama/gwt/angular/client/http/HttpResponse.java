package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.core.client.$;

public interface HttpResponse<T extends $> {

	int getStatus();
	T getData();
	
}
class HttpResponseJSO<T extends $> extends $ implements HttpResponse<T> {

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