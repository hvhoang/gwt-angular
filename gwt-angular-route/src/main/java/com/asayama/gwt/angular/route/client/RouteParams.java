package com.asayama.gwt.angular.route.client;

import java.util.Date;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSObject;

public class RouteParams implements Service, NGObjectWrapper {

	protected NGRouteParams ngo;
	
	public String getString(String key) {
		return getNGObject().getStringParam(key);
	}
	
	public Integer getInteger(String key) {
		return getNGObject().getIntegerParam(key);
	}
	
	public Double getDouble(String key) {
		return getNGObject().getDoubleParam(key);
	}
	
	public Date getDate(String key) {
		return getNGObject().getDateParam(key);
	}
	
	public <T extends JSObject> T getObject(String key) {
		return getNGObject().getObjectParam(key);
	}
	
	@Override
	public void wrap(NGObject ngo) {
		this.ngo = NGObject.cast(ngo);
	}
	NGRouteParams getNGObject() {
		return ngo;
	}
}
@Bind("$routeParams")
class NGRouteParams extends NGObject {

	protected NGRouteParams() {
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
