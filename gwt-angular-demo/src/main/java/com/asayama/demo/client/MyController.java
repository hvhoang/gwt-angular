package com.asayama.demo.client;

import java.util.ArrayList;
import java.util.List;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.Scope;
import com.asayama.gwt.angular.client.location.HashParam;
import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.client.services.q.Deferred;
import com.asayama.gwt.angular.client.services.q.Promise;
import com.asayama.gwt.angular.client.services.q.Q;
import com.asayama.gwt.angular.client.services.q.SuccessCallback;
import com.asayama.gwt.angular.route.client.RouteParams;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.Event;

public class MyController implements Controller {

	// Public final fields are directly bound to AngularJS's $scope
	public static final String GREETING = MyControllerConstants.INSTANCE.greeting();
	public static final String STRANGER = MyControllerConstants.INSTANCE.stranger();
	
	protected RouteParams routeParams;
	protected Location location;
	protected Q q;

	Scope scope;
	String clickable;
	String name;
	Customers customers;
	
	@Override
	public void onControllerLoad() {

		GWT.log("entering MyController.onControllerLoad");
		
		String name = routeParams.getString("name");
		setName(name);

		setClickable("Click me");

		String url = GWT.getModuleBaseForStaticFiles() + "api/customer";

		try {

//			http.get(url, new HttpCallback<Customers>() {
//				@Override
//				public void onSuccess(Customers object) {
//					setCustomers(object);
//				}
//				@Override
//				public void onError(Customers object) {
//				}
//			});

			// $q + RequestBuiler
			// Try returning PromiseJSO to the view and see if view can resolve it.
			Promise promise = loadCustomers(url);
			promise.then(new SuccessCallback() {
				@Override
				public void success(Object... args) {
					Response response = (Response) args[1];
					String jsonString = response.getText();
					Customers customers = Customers.parse(jsonString);
					setCustomers(customers);
				}
			});
		
		} catch (RequestException e) {
			GWT.log("Exception while calling " + url, e);
		}
		
	}
	
	public Promise loadCustomers(final String url) throws RequestException {
		final Deferred deferred = q.defer();
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		GWT.log("[GET] " + url);
		builder.sendRequest(null, new RequestCallback() {
			@Override
			public void onResponseReceived(Request request, Response response) {
				int status = response.getStatusCode();
				GWT.log("[" + status + "] " + url);
//				if (status == 200) {
//					String responseString = response.getText();
//					Customers customers = Customers.parse(responseString);
//					deferred.resolve(customers);
//				}
				deferred.resolve(request, response);
			}
			@Override
			public void onError(Request request, Throwable exception) {
				GWT.log("[ERR] " + url, exception);
//				deferred.reject(null);//FIXME figure out what to do here
				deferred.reject(request, exception);
			}
		});
		return deferred.promise();
	}

	// Public event handler are automatically wired to AngularJS's $scope.
	
	public void onClickClickable(Event event) {
//		location.setHashParam("name", "You Clicked Me!");
		List<HashParam> params = new ArrayList<HashParam>();
		params.add(new HashParam("name", "You Clicked Me!"));
		params.add(new HashParam("foo", "bar"));
		location.setHashParam(params);
	}
	
	// Public getters and setters are automatically wired to AngularJS's $scope.
	
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public String getClickable() {
		return clickable;
	}
	public void setClickable(String clickable) {
		this.clickable = clickable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
interface MyControllerConstants extends Constants {
	
	static final MyControllerConstants INSTANCE = GWT.create(MyControllerConstants.class);
	
	@DefaultStringValue("Hello")
	String greeting();
	
	@DefaultStringValue("Stranger")
	String stranger();
}