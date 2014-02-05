package com.asayama.gwt.angular.route.client;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Provider;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.google.gwt.core.client.JavaScriptObject;

public class RouteProvider implements Provider, NGObjectWrapper {

	protected RouteProviderJSO delegate;
	
	public RouteProvider when(String route, Template action) {
		delegate.when(route, action);
		return this;
	}
	public RouteProvider when(String route, Redirect action) {
		delegate.when(route, action);
		return this;
	}
	public RouteProvider otherwise(Template action) {
		delegate.otherwise(action);
		return this;
	}
	public RouteProvider otherwise(Redirect action) {
		delegate.otherwise(action);
		return this;
	}

	@Override
	public void wrap(NGObject delegate) {
		this.delegate = delegate == null ? null : delegate.<RouteProviderJSO>cast();
	}

}
@Bind("$routeProvider")
class RouteProviderJSO extends NGObject {

	protected RouteProviderJSO() {
	}

	final native void when(String route, JavaScriptObject action) /*-{
		this.when(route, action);
	}-*/;
	
	final native void otherwise(JavaScriptObject action) /*-{
		this.otherwise(action);
	}-*/;
}
