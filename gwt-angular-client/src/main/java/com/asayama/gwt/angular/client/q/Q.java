package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.AngularJSO;
import com.asayama.gwt.angular.client.Constructable;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSObject;

public class Q implements Service, Wrapper<QJSO>, Constructable {

	QJSO delegate;
	
	public <T extends JSObject> Deferred<T> defer() {
		Deferred<T> deferred = new Deferred<T>();
		deferred.setDelegate(delegate._defer());
		return deferred;
	}

	@Override
	public QJSO getDelegate() {
		return delegate;
	}

	@Override
	public void setDelegate(JSObject delegate) {
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
class QJSO extends AngularJSO {

	protected QJSO(){
	}
	
	final native <T extends JSObject> DeferredJSO<T> _defer() /*-{
		return this.defer();
	}-*/;

}
