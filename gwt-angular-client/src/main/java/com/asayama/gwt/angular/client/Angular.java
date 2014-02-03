package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

interface ModuleCreator<T extends Module> extends Creator<T> {
}
public class Angular {
	
	public static <T extends Module> T module(Class<T> klass) {
		ModuleCreator<T> creator = GWT.create(ModuleCreator.class);
		final T object = creator.create(klass);
		final String name = klass.getName();
		GWT.log("registering " + name + " with Anuglar");
		object.wrap(_module(name, null, new Invoker(new Closure<JSObject>() {
			public void closure(JSObject jso) {
				//TODO implement me
			}
		})));
		return object;
	}
	
	public static void bootstrap(Module... modules) {
		JsArrayString jsarray = (JsArrayString) JavaScriptObject.createArray();
		for (Module module : modules) {
			jsarray.push(module.getName());
		}
		_bootstrap(jsarray);
	}

	//TODO Support module dependency
	//TODO Figure out how to support Creator
	private static native ModuleJSO _module(String name, JsArrayString requires, Invoker invoker) /*-{
		return $wnd.angular.module(name, [ "ngRoute", "ngSanitize" ], function () {
			invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/JSObject;)({});
		});
	}-*/;
	
	private static native void _bootstrap(JsArrayString modules) /*-{
		$wnd.angular.bootstrap($doc, modules);
	}-*/;
	
}
