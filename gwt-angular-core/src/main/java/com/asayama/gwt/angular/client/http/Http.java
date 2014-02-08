package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;

public class Http implements Service, NGObjectWrapper {
	
	NGHttp delegate;
	
	@Override
	public void wrap(NGObject ngo) {
		this.delegate = NGObject.cast(ngo);
	}

}
@Bind("$http")
class NGHttp extends NGObject {

	protected NGHttp() {
	}

}
