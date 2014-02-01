package com.asayama.gwt.angular.client.route;

import com.asayama.gwt.angular.client.Constructor;
import com.asayama.gwt.angular.client.Provider;
import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.core.client.JSObject;
import com.asayama.gwt.core.client.Invoker;
import com.google.gwt.core.client.JavaScriptObject;

public class RouteProvider implements Provider, Wrapper<RouteProviderJSO>, Constructor {

	RouteProviderJSO delegate;
	
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

	// Wrapper Methods
	
	@Override
	public RouteProviderJSO getDelegate() {
		return delegate;
	}
	
	@Override
	public void setDelegate(JSObject delegate) {
		this.delegate = delegate.cast();
	}

	// Constructor Methods
	
	@Override
	public native JSObject constructor(Invoker invoker) /*-{
		return [ "$routeProvider",
			function ($routeProvider) {
				invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/JSObject;)($routeProvider);
				return $routeProvider;
			}];
	}-*/;

}
class RouteProviderJSO extends JSObject {

	protected RouteProviderJSO() {
	}

	final native void when(String route, JavaScriptObject action) /*-{
		this.when(route, action);
	}-*/;
	
	final native void otherwise(JavaScriptObject action) /*-{
		this.otherwise(action);
	}-*/;
}
