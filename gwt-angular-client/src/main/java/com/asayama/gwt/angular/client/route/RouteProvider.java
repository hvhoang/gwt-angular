package com.asayama.gwt.angular.client.route;

import com.asayama.gwt.angular.client.Constructor;
import com.asayama.gwt.angular.client.Provider;
import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Invoker;
import com.google.gwt.core.client.JavaScriptObject;

public class RouteProvider implements Provider {

	RouteProviderJSO delegate;
	
	public void onProviderLoad(RouteProviderJSO delegate) {
		this.delegate = delegate;
	}
	
	public RouteProvider when(String route, Route action) {
		delegate.when(route, action);
		return this;
	}
	public RouteProvider when(String route, Redirect action) {
		delegate.when(route, action);
		return this;
	}
	public RouteProvider otherwise(Route action) {
		delegate.otherwise(action);
		return this;
	}
	public RouteProvider otherwise(Redirect action) {
		delegate.otherwise(action);
		return this;
	}
}
class RouteProviderImpl extends RouteProvider implements Wrapper<RouteProviderJSO>, Constructor {

	// Constructor Methods

	@Override
	public native $ constructor(Invoker invoker) /*-{
		return [ "$routeProvider",
			function ($routeProvider) {
				invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/$;)($routeProvider);
				return $routeProvider;
			}];
	}-*/;

	// Wrapper Methods
	
	@Override
	public $ get$() {
		return delegate;
	}
	
	@Override
	public void set$(RouteProviderJSO delegate) {
		this.delegate = delegate;
	}

}
class RouteProviderJSO extends $ {

	protected RouteProviderJSO() {
	}

	final native void when(String route, JavaScriptObject action) /*-{
		this.when(route, action);
	}-*/;
	
	final native void otherwise(JavaScriptObject action) /*-{
		this.otherwise(action);
	}-*/;
}
