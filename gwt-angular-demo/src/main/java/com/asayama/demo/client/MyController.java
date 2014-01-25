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
	Customer customers;
	
	@Override
	public void onControllerLoad(final Scope scope) {
		this.scope = scope;
		setTitle(MyControllerConstants.INSTANCE.title());
		final String url = "/api/customer";
		try {
			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
			builder.sendRequest(null, new RequestCallback() {
				@Override
				public void onResponseReceived(Request request, Response response) {
					int status = response.getStatusCode();
					if (status == 200) {
						Customer customers = Customer.parse(response.getText());
						setCustomers(customers);
						scope.digest(); //we need this because this is an async callback
					}
				}
				@Override
				public void onError(Request request, Throwable exception) {
					GWT.log(url, exception);
				}
			});
		} catch (RequestException e) {
			GWT.log("Exception", e);
		}
	}
	
	// Public event handler are automatically wired to AngularJS's $scope.
	
	public void onClickTitle(Event event) {
		setTitle("You clicked me!");
	}
	
	// Public getters and setters are automatically wired to AngularJS's $scope.
	
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
	public Customer getCustomers() {
		return customers;
	}
	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

}
interface MyControllerConstants extends Constants {
	
	static final MyControllerConstants INSTANCE = GWT.create(MyControllerConstants.class);
	
	@DefaultStringValue("Click me")
	String title();
}