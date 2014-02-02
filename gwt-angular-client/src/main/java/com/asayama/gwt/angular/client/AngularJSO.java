package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.JsArrayString;

public class AngularJSO extends JSObject {

	protected AngularJSO() {
	}

	public final JSObject getConstructor(Invoker invoker, String... dependencies) {
		JsArrayString jsarray = JSObject.create().cast();
		if (dependencies != null) {
			for (String dependency : dependencies) {
				jsarray.push(dependency);
			}
		}
		return _getConstructor(invoker, jsarray);
	}
	
	private final native JSObject _getConstructor(Invoker invoker, JsArrayString dependencies) /*-{
		dependencies.push(function (arguments) {
			return invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/JSObject;)(arguments);
		});
		return dependencies;
	}-*/;

}
