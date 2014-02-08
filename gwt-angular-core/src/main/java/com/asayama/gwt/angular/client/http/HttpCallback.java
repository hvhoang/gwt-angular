package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.q.PromiseCallback;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;


public abstract class HttpCallback extends PromiseCallback {

	abstract public void onSuccess(Request request, Response response);
	abstract public void onError(Request request, Exception exception);
	public void onSignal(Request request) {
		//noop
	}

	@Override
	public final void success(Object... args) {
		Request request = null;
		Response response = null;
		if (args != null && args.length > 0) {
			request = (Request) args[0];
		}
		if (args != null && args.length > 1) {
			response = (Response) args[1];
		}
		onSuccess(request, response);
	}
	
	@Override
	public final void error(Object... args) {
		Request request = null;
		Exception exception = null;
		if (args != null && args.length > 0) {
			request = (Request) args[0];
		}
		if (args != null && args.length > 1) {
			exception = (Exception) args[1];
		}
		onError(request, exception);
	}
	
	@Override
	public final void notify(Object... args) {
		Request request = null;
		if (args != null && args.length > 0) {
			request = (Request) request;
		}
		onSignal(request);
	}
	
}
