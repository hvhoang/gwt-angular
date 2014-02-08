package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSObject;

public class Q implements Service, NGObjectWrapper<QJSO> {

	protected QJSO delegate;
	
	public <T extends JSObject> Deferred defer() {
		Deferred deferred = new Deferred();
		deferred.delegate = delegate._defer();
		return deferred;
	}

	@Override
	public void wrap(QJSO ngo) {
		this.delegate = NGObject.cast(ngo);
	}

}
@Bind("$q")
class QJSO extends NGObject {

	protected QJSO(){
	}
	
	final native DeferredJSO _defer() /*-{
		return this.defer();
	}-*/;

}
