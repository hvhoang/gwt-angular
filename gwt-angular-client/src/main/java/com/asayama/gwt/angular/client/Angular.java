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
		T module = creator.create(klass);
		String name = klass.getName();
		return module(name, module);
	}
	
	public static <T extends Module> T module(String name, T module) {
		GWT.log("registering " + name + " with Anuglar");
		module.wrap($module(name, null, new Invoker(new Closure<JSObject>() {
			public void closure(JSObject jso) {
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
		$bootstrap(jsarray);
	}

	//TODO Support module dependency
	static native ModuleJSO $module(String name, JsArrayString requires, Invoker invoker) /*-{
		return $wnd.angular.module(name, [ "ngRoute", "ngSanitize" ], function () {
			invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/asayama/gwt/core/client/JSObject;)({});
		});
	}-*/;
	
	static native void $bootstrap(JsArrayString modules) /*-{
		$wnd.angular.bootstrap($doc, modules);
	}-*/;
	
}
