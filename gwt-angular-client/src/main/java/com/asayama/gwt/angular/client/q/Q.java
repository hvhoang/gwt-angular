/*
 * com.google.gwt.dev.jjs.InternalCompilerException: Already seen an implementing JSO subtype (Http) for interface (Constructor) while examining newly-added type (Q). This is a bug in JSORestrictionsChecker.
 */
package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Constructor;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Invoker;

@Bind("$q")
public class Q extends $ implements Service, Constructor {

	protected Q(){
	}
	
	public final <T extends $> Deferred<T> defer() {
		Deferred<T> deferred = new Deferred<T>();
		deferred.setDelegate(_defer());
		return deferred;
	}
	
	final native <T extends $> DeferredJSO<T> _defer() /*-{
		return this.defer();
	}-*/;

	// Constructor Method
	
	@Override
	public final native $ constructor(Invoker invoker) /*-{
		return [ '$q', function($q) {
			invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/$;)($q);
			return $q;
		}];
	}-*/;

}
