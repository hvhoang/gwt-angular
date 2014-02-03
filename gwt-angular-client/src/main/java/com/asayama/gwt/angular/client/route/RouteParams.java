package com.asayama.gwt.angular.client.route;

import java.util.Date;

import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.angular.client.annotations.Depends;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.JsArray;

@Depends("$routeParams")
public class RouteParams implements Service, Wrapper {

	RouteParamsJSO delegate;
	
	public String getString(String key) {
		return delegate.getStringParam(key);
	}
	
	public Integer getInteger(String key) {
		return delegate.getIntegerParam(key);
	}
	
	public Double getDouble(String key) {
		return delegate.getDoubleParam(key);
	}
	
	public Date getDate(String key) {
		return delegate.getDateParam(key);
	}
	
	public <T extends JSObject> T getObject(String key) {
		return delegate.getObjectParam(key);
	}
	
	// Wrapper Methods
	
	@Override
	public void wrap(JsArray<?> jsarray) {
		if (jsarray != null && jsarray.length() > 0) {
			this.delegate = jsarray.get(0).cast();
		}
	}

}
class RouteParamsJSO extends JSObject {

	protected RouteParamsJSO() {
	}

	public final String getStringParam(String key) {
		return getString(key);
	}
	
	public final Integer getIntegerParam(String key) {
		return getInteger(key);
	}
	
	public final Double getDoubleParam(String key) {
		return getDouble(key);
	}
	
	public final Date getDateParam(String key) {
		return getDate(key);
	}
	
	public final <T extends JSObject> T getObjectParam(String key) {
		return getObject(key);
	}
}
