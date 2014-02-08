package com.asayama.gwt.angular.client.http;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;

public class Http implements Service, NGObjectWrapper {
	
	NGHttp ngo;
	
	@Override
	public void wrap(NGObject ngo) {
		this.ngo = NGObject.cast(ngo);
	}
	NGHttp getNGObject() {
		return ngo;
	}

}
@Bind("$http")
class NGHttp extends NGObject {

	protected NGHttp() {
	}

}
