package com.asayama.gwt.angular.client.route;

import com.asayama.gwt.angular.client.Provider;
import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.angular.client.annotations.Depends;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

@Depends("$routeProvider")
public class RouteProvider implements Provider, Wrapper {

	RouteProviderJSO delegate;
	
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

	// Wrapper Methods
	
	@Override
	public void wrap(JsArray<?> jsarray) {
		if (jsarray != null && jsarray.length() > 0) {
			this.delegate = jsarray.get(0).cast();
		}
	}

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
