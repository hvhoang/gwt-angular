package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.angular.client.annotations.Depends;
import com.asayama.gwt.core.client.JSObject;

@Depends("$q")
public class Q implements Service, Wrapper {

	QJSO delegate;
	
	@SuppressWarnings("unchecked")
	public <T extends JSObject> Deferred<T> defer() {
		Deferred<T> deferred = new Deferred<T>();
		deferred.wrap((DeferredJSO<T>) delegate._defer());
		return deferred;
	}

	@Override
	public void wrap(JSObject delegate) {
		this.delegate = delegate.cast();
	}

}
class QJSO extends JSObject {

	protected QJSO(){
	}
	
	final native <T extends JSObject> DeferredJSO<T> _defer() /*-{
		return this.defer();
	}-*/;

}
