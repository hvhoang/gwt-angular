package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Constructor;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Invoker;

public class Q implements Service, Wrapper<QJSO>, Constructor {

	public Deferred defer() {
		Deferred deferred = new Deferred();
		deferred.setDelegate(delegate.defer());
		return deferred;
	}
	
	// Constructor Method
	
	@Override
	public native $ constructor(Invoker invoker) /*-{
		return [ '$q', function($q) {
			invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/$;)($q);
		}];
	}-*/;

	// Wrapper Methods
	
	QJSO delegate = null;
	
	@Override
	public QJSO getDelegate() {
		return this.delegate;
	}

	@Override
	public void setDelegate(QJSO delegate) {
		this.delegate = delegate;
	}

}
class QJSO extends $ {
	
	protected QJSO() {
	}

	final native DeferredJSO defer() /*-{
		return this.defer();
	}-*/;

}
