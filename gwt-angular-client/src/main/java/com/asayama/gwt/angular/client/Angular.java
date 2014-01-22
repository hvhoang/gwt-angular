package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Function;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;


public class Angular {
	
	static final AngularJSO delegate = AngularJSO.getInstance();

	public static <T extends Module> T module(String name, T module) {
		module.setDelegate(delegate.module(name, null, new Function.Proxy<$>(new Function<$>() {
			@Override
			public $ invoke($ jso) {
				//TODO implement me
				return null;
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

	final native ModuleJSO module(String name, JsArrayString requires, Function.Proxy<$> proxy) /*-{
		return this.module(name, [ "ngRoute", "ngSanitize" ], function () {
			proxy.@com.asayama.gwt.core.client.Function.Proxy::invoke(Lcom/asayama/gwt/core/client/$;)({});
		});
	}-*/;
	
	final native void bootstrap(JsArrayString modules) /*-{
		this.bootstrap($doc, modules);
	}-*/;
}