package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Constructor;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSObject;
import com.asayama.gwt.core.client.Invoker;

@Bind("$q")
public class Q extends JSObject implements Service, Constructor {

	protected Q(){
	}
	
	public final <T extends JSObject> Deferred<T> defer() {
		Deferred<T> deferred = new Deferred<T>();
		deferred.setDelegate($defer());
		return deferred;
	}
	
	// Constructor Method
	//
	// com.google.gwt.dev.jjs.InternalCompilerException: Already seen an 
	// implementing JSO subtype (Http) for interface (Constructor) while 
	// examining newly-added type (Q). This is a bug in JSORestrictionsChecker.
	//
	
	@Override
	public final native JSObject constructor(Invoker invoker) /*-{
		return [ '$q', function($q) {
			invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/JSObject;)($q);
			return $q;
		}];
	}-*/;

	final native <T extends JSObject> DeferredJSO<T> $defer() /*-{
		return this.defer();
	}-*/;

}