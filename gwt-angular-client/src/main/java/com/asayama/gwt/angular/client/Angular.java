package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Invoker;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class Angular {
	
	static final AngularJSO delegate = AngularJSO.getInstance();

	public static <T extends Module> T module(String name, T module) {
		module.set$(delegate.module(name, null, new Invoker(new Closure<$>() {
			public void closure($ jso) {
				//TODO implement me
			}
		})));
		return module;
	}
	
	public static void bootstrap(Module... modules) {
		JsArrayString jsarray = (JsArrayString) JavaScriptObject.createArray();
		for (Module module : modules) {
			jsarray.push(module.getName());
		}
		delegate.bootstrap(jsarray);
	}
}
class AngularJSO extends JavaScriptObject {

	static native AngularJSO getInstance() /*-{
		return $wnd.angular;
	}-*/;
	
	protected AngularJSO() {
	}

	final native ModuleJSO module(String name, JsArrayString requires, Invoker invoker) /*-{
		return this.module(name, [ "ngRoute", "ngSanitize" ], function () {
			invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/$;)({});
		});
	}-*/;
	
	final native void bootstrap(JsArrayString modules) /*-{
		this.bootstrap($doc, modules);
	}-*/;
}