package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;

public class Http implements Service, NGObjectWrapper<HttpJSO> {
	
	HttpJSO delegate;
	
	@Override
	public void wrap(HttpJSO ngo) {
		this.delegate = NGObject.cast(ngo);
	}

}
@Bind("$http")
class HttpJSO extends NGObject {

	protected HttpJSO() {
	}

}
