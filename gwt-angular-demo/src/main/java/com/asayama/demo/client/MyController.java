package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.Scope;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.Event;

public class MyController implements Controller {

	// The service objects are injected at runtime. The fields must be declared
	// "protected".
	// TODO implement some examples
	
	// Other attributes of the controller can be used as reference to view model.
	Scope scope;
	String title;
	String httpStatus;

	@Override
	public void onControllerLoad(Scope scope) {
		this.scope = scope;
		setTitle(MyControllerConstants.INSTANCE.title());
		getCustomer();
	}
	
	void getCustomer() {
		String url = "/api/customer";
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		try {
			builder.sendRequest(null, new RequestCallback() {
				@Override
				public void onResponseReceived(Request request, Response response) {
					String status = response.getStatusText();
					setHttpStatus(status);
					scope.digest();
				}
				@Override
				public void onError(Request request, Throwable exception) {
					String status = exception.getMessage();
					setHttpStatus(status);
					scope.digest();
				}
			});
		} catch (RequestException e) {
			GWT.log("Exception", e);
		}
	}
	
	public void onClickTitle(Event event) {
		setTitle("You clicked me!");
	}

	// Public methods are bound to AngularJS's $scope automatically.
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

}
interface MyControllerConstants extends Constants {
	
	static final MyControllerConstants INSTANCE = GWT.create(MyControllerConstants.class);
	
	@DefaultStringValue("Click me")
	String title();
}