package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.Scope;
import com.asayama.gwt.angular.client.q.Deferred;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.angular.client.q.SuccessCallback;
import com.asayama.gwt.angular.client.route.RouteParams;
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
	protected Q q;
//	protected Http http;

	Scope scope;
	String clickable;
	String name;
	Customers customers;
	
	@Override
	public void onControllerLoad(final Scope scope) {
		this.scope = scope;
		setClickable("Click me");

		// $scope.$digest() + RequestBuilder
//		loadCustomersWithRequestBuilder();

		// $q + RequestBuiler
		// Try returning PromiseJSO to the view and see if view can resolve it.
		Promise<Customers> promise = loadCustomers();
		promise.then(new SuccessCallback<Customers>() {
			@Override
			public void onSuccess(Customers object) {
				setCustomers(object);
			}
		});
		
		// $http
//		http.get("/myapp/api/customer", new HttpCallback<Customers>() {
//			@Override
//			public void onSuccess(HttpResponse<Customers> response) {
//				setCustomers(response.getData());
//			}
//			@Override
//			public void onError(HttpResponse<Customers> response) {
//			}
//		});
	}
	
	public void onInjection(Q q) {
		GWT.log("MyController.onInjection: q=" + q);
	}
	
	public void onInjection(RouteParams routeParams) {
		String name = routeParams.getString("name");
		GWT.log("name=" + name);
		setName(name == null ? STRANGER : name);
	}
	
//	public void onInjection(Http http) {
//		GWT.log("MyController.onInjection: http=" + http);
//	}
	
	public Promise<Customers> loadCustomers() {
		final Deferred<Customers> deferred = q.defer();
		final String url = "/myapp/api/customer";
		try {
			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
			GWT.log("[GET] " + url);
			builder.sendRequest(null, new RequestCallback() {
				@Override
				public void onResponseReceived(Request request, Response response) {
					int status = response.getStatusCode();
					GWT.log("[" + status + "] " + url);
					if (status == 200) {
						Customers customers = Customers.parse(response.getText());
						deferred.resolve(customers);
					}
				}
				@Override
				public void onError(Request request, Throwable exception) {
					GWT.log("[ERR] " + url, exception);
					deferred.reject(null);//FIXME figure out what to do here
				}
			});
			return deferred.promise();

		} catch (RequestException e) {
			GWT.log("Exception", e);
			return null; //FIXME figure out what to do where, too.
		}
	}

//	private void loadCustomersWithRequestBuilder() {
//		final String url = "/myapp/api/customer";
//		try {
//			RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
//			GWT.log("[GET] " + url);
//			builder.sendRequest(null, new RequestCallback() {
//				@Override
//				public void onResponseReceived(Request request, Response response) {
//					int status = response.getStatusCode();
//					GWT.log("[" + status + "] " + url);
//					if (status == 200) {
//						Customers customers = Customers.parse(response.getText());
//						setCustomers(customers);
//						scope.digest(); //we need this because this is an async callback
//					}
//				}
//				@Override
//				public void onError(Request request, Throwable exception) {
//					GWT.log("[ERR] " + url, exception);
//				}
//			});
//	
//		} catch (RequestException e) {
//			GWT.log("Exception", e);
//		}
//	}
	
	// Public event handler are automatically wired to AngularJS's $scope.
	
	public void onClickClickable(Event event) {
		setClickable("You clicked me!");
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