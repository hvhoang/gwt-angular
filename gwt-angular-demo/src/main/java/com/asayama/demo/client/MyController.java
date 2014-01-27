package com.asayama.demo.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.Scope;
import com.asayama.gwt.angular.client.q.Deferred;
import com.asayama.gwt.angular.client.q.Promise;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.angular.client.q.SuccessCallback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.user.client.Event;

public class MyController implements Controller {

	protected Q q;
//	protected Http http;

	Scope scope;
	String title;
	String httpStatus;
	Customers customers;
	
	@Override
	public void onControllerLoad(final Scope scope) {
		this.scope = scope;
		setTitle(MyControllerConstants.INSTANCE.title());

		// $scope.$digest() + RequestBuilder
//		loadCustomers();

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

//	private void loadCustomers() {
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
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

}
interface MyControllerConstants extends Constants {
	
	static final MyControllerConstants INSTANCE = GWT.create(MyControllerConstants.class);
	
	@DefaultStringValue("Click me")
	String title();
}