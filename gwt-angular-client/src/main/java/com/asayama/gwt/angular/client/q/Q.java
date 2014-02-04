package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Q implements Service, Wrapper {

	protected QJSO delegate;
	
	@SuppressWarnings("unchecked")
	public <T extends JSObject> Deferred defer() {
		Deferred deferred = new Deferred();
		JsArray<DeferredJSO> jsarray = (JsArray<DeferredJSO>) JavaScriptObject.createArray();
		jsarray.push(delegate._defer());
		deferred.onInjection(jsarray);
		return deferred;
	}

	@Override
	public void onInjection(JsArray<?> jsarray) {
		if (jsarray != null && jsarray.length() > 0) {
			this.delegate = jsarray.get(0).cast();
		}
	}

}
@Bind("$q")
class QJSO extends JSObject implements NGObject {

	protected QJSO(){
	}
	
	final native DeferredJSO _defer() /*-{
		return this.defer();
	}-*/;

}
