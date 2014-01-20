package com.asayama.gwt.angular.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;


public class Angular {
	
	static final AngularJSO delegate = AngularJSO.getInstance();

	public static <T extends Module> T module(Class<T> klass) {
		T module = GWT.create(klass);
		module.setDelegate(delegate.module(klass.getName(), null, new Function.Proxy(new Function() {
			@Override
			public JavaScriptObject invoke(Object... args) {
				//TODO implement me
				return null;
			}
		})));
		return module;
	}
	
	public static void bootstrap(Module... modules) {
		JsArrayString jsarray = (JsArrayString) JavaScriptObject.createArray();
		for (Module module : modules) {
			jsarray.push(module.getClass().getName());
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

	final native ModuleJSO module(String name, JsArrayString requires, Function.Proxy proxy) /*-{
		return this.module(name, requires||[], function () {
			proxy.@com.asayama.gwt.angular.client.Function.Proxy::invoke(Lcom/google/gwt/core/client/JsArray;)([]);
		});
	}-*/;
	
	final native void bootstrap(JsArrayString modules) /*-{
		this.bootstrap($doc, modules);
	}-*/;
}