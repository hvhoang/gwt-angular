package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.AngularJSO;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSObject;

@Bind("$q")
public class Q extends AngularJSO implements Service {

	protected Q(){
	}
	
	public final <T extends JSObject> Deferred<T> defer() {
		Deferred<T> deferred = new Deferred<T>();
		deferred.setDelegate(_defer());
		return deferred;
	}
	
	final native <T extends JSObject> DeferredJSO<T> _defer() /*-{
		return this.defer();
	}-*/;

}
