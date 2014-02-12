package com.asayama.demo.client.controller;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.http.client.HttpClient;
import com.asayama.gwt.angular.http.client.HttpClientCallback;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

public class Example4Controller implements Controller {

	// Fields of type that implements Injectable are injected by the framework
	private HttpClient http;

	// Other fields are used to represent the state of this controller
	private Customers customers;
	
	@Override
	public void onControllerLoad() {
		String url = GWT.getModuleBaseForStaticFiles() + "api/customer";
		try {
			HttpClientCallback callback = new HttpClientCallback() {
				@Override
				public void onSuccess(Request request, Response response) {
					Customers customers = Customers.parse(response.getText());
					setCustomers(customers);
				}
				@Override
				public void onError(Request request, Exception exception) {
					GWT.log("onError", exception);
				}
			};
			http.get(url, callback);
		} catch (RequestException e) {
			GWT.log("Exception while calling " + url, e);
		}
		
	}

	// Public getters and setters are automatically wired to AngularJS's $scope.
	
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

}
class Customers extends JSObject  {
	protected Customers() {
	}
}