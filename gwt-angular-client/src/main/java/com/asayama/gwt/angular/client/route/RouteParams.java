package com.asayama.gwt.angular.client.route;

import java.util.Date;

import com.asayama.gwt.angular.client.Constructor;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Invoker;

public class RouteParams implements Service, Wrapper<RouteParamsJSO>, Constructor {

	RouteParamsJSO delegate;
	
	public String getString(String key) {
		return delegate.getString(key);
	}
	
	public Integer getInteger(String key) {
		return delegate.getInteger(key);
	}
	
	public Double getDouble(String key) {
		return delegate.getDouble(key);
	}
	
	public Date getDate(String key) {
		return delegate.getDate(key);
	}
	
	public <T extends $> T getObject(String key) {
		return delegate.getObject(key);
	}
	
	// Wrapper Methods
	
	@Override
	public RouteParamsJSO getDelegate() {
		return delegate;
	}
	
	@Override
	public void setDelegate($ delegate) {
		this.delegate = delegate.cast();
	}

	// Constructor Methods
	
	@Override
	public native $ constructor(Invoker invoker) /*-{
		return [ "$routeParams",
			function ($routeParams) {
				invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/$;)($routeParams);
				return $routeParams;
			}];
	}-*/;

}
class RouteParamsJSO extends $ {

	protected RouteParamsJSO() {
	}

	public final String getString(String key) {
		return $string(key);
	}
	
	public final Integer getInteger(String key) {
		return $integer(key);
	}
	
	public final Double getDouble(String key) {
		return $double(key);
	}
	
	public final Date getDate(String key) {
		return $date(key);
	}
	
	public final <T extends $> T getObject(String key) {
		return $object(key);
	}
}
