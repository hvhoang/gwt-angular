package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.jsni.client.JSArray;
import com.asayama.gwt.jsni.client.JSObject;

public class Deferred {

	JSDeferred jso = null;

	public void notify(Object... values) {
		jso.notify(JSArray.create(values));
	}
	
	public void resolve(Object... values) {
		jso.resolve(JSArray.create(values));
	}
	
	public void reject(Object... values) {
		jso.reject(JSArray.create(values));
	}
	
	public Promise promise() {
		return jso.promise();
	}
	
}
class JSDeferred extends JSObject {

	protected JSDeferred() {
	}

	final native void notify(JSArray<Object> value) /*-{
		this.notify(value);
	}-*/;
	
	final native void resolve(JSArray<Object> value) /*-{
		this.resolve(value);
	}-*/;
	
	final native void reject(JSArray<Object> value) /*-{
		this.reject(value);
	}-*/;
	
	final native Promise promise() /*-{
		return this.promise;
	}-*/;

}
