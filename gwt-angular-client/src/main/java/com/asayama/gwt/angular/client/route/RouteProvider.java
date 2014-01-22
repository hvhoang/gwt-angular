package com.asayama.gwt.angular.client.route;

import com.asayama.gwt.angular.client.Provider;
import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Function;
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
class RouteProviderImpl extends RouteProvider implements Provider.Constructor {

	public void onProviderLoad(RouteProviderJSO delegate) {
		super.onProviderLoad(delegate);
	}

	@Override
	public native <T extends Provider> $ _getConstructor(T me, Function.Proxy<$> proxy) /*-{
		return [ "$routeProvider",
			function ($routeProvider) {
				me.@com.asayama.gwt.angular.client.route.RouteProviderImpl::onProviderLoad(Lcom/asayama/gwt/angular/client/route/RouteProviderJSO;)($routeProvider);
				proxy.@com.asayama.gwt.core.client.Function.Proxy::invoke(Lcom/asayama/gwt/core/client/$;)($routeProvider);
				return $routeProvider;
			}];
	}-*/;

}
class RouteProviderJSO extends JavaScriptObject {

	protected RouteProviderJSO() {
	}

	final native void when(String route, JavaScriptObject action) /*-{
		this.when(route, action);
	}-*/;
	
	final native void otherwise(JavaScriptObject action) /*-{
		this.otherwise(action);
	}-*/;
}
