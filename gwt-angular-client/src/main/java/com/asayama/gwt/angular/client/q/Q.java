package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.Wrapper;
import com.asayama.gwt.angular.client.annotations.Depends;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

@Depends("$q")
public class Q implements Service, Wrapper {

	QJSO delegate;
	
	@SuppressWarnings("unchecked")
	public <T extends JSObject> Deferred defer() {
		Deferred deferred = new Deferred();
		JsArray<DeferredJSO> jsarray = (JsArray<DeferredJSO>) JavaScriptObject.createArray();
		jsarray.push(delegate._defer());
		deferred.wrap(jsarray);
		return deferred;
	}

	@Override
	public void wrap(JsArray<?> jsarray) {
		if (jsarray != null && jsarray.length() > 0) {
			this.delegate = jsarray.get(0).cast();
		}
	}

}
class QJSO extends JSObject {

	protected QJSO(){
	}
	
	final native DeferredJSO _defer() /*-{
		return this.defer();
	}-*/;

}
