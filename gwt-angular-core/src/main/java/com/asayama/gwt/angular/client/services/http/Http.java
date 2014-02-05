package com.asayama.gwt.angular.client.services.http;

import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.services.q.Deferred;
import com.asayama.gwt.angular.client.services.q.Q;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

public class Http implements Service {

	protected Q q; //TODO Must figure out dependency injection
	
	//TODO Expose RequestCallback and still support Promise
	public <T extends JSObject> Request get(final String url, HttpCallback callback) throws RequestException {
		final Deferred deferred = q.defer();
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		GWT.log("[GET] " + url);
		Request request = builder.sendRequest(null, new RequestCallback() {
			@Override
			public void onResponseReceived(Request request, Response response) {
				int status = response.getStatusCode();
				GWT.log("[" + status + "] " + url);
				deferred.resolve(response);
//				if (status == 200) {
//					String responseString = response.getText();
//					T jso = T.parse(responseString);
//					deferred.resolve(jso);
//				}
			}
			@Override
			public void onError(Request request, Throwable exception) {
				GWT.log("[EXCEPTION] " + url, exception);
				deferred.reject(exception);//FIXME figure out what to do here
			}
		});
		deferred.promise().then(callback);
		return request;
	}
	
}
