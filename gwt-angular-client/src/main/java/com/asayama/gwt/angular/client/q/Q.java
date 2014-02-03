package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.AngularWrapper;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSObject;

public class Q implements Service, AngularWrapper {

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

	// Constructor Methods
	
	@Override
	public native JSObject construct(Invoker invoker) /*-{
		return [ "$q",
			function (arguments) {
				invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/JSObject;)(arguments);
				return arguments;
			}];
	}-*/;
}
class QJSO extends JSObject {

	protected QJSO(){
	}
	
	final native <T extends JSObject> DeferredJSO<T> _defer() /*-{
		return this.defer();
	}-*/;

}
