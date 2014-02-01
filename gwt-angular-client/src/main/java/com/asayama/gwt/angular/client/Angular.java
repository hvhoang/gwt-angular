package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Invoker;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class Angular {
	
	static final AngularJSO delegate = AngularJSO.getInstance();

	public static <T extends Module> T module(Class<T> klass) {
		ModuleCreator<T> creator = GWT.create(ModuleCreator.class);
		T module = creator.create(klass);
		return module(module);
	}
	
	public static <T extends Module> T module(T module) {
		return module(module.getClass().getName(), module);
	}

	public static <T extends Module> T module(String name, T module) {
		GWT.log("registering " + name + " with Anuglar");
		module.setDelegate(delegate.module(name, null, new Invoker(new Closure<$>() {
			public void closure($ jso) {
				//TODO implement me
			}
		})));
		return module;
	}
	
	public static void bootstrap(Module module) {
//		JsArrayString jsarray = (JsArrayString) JavaScriptObject.createArray();
//		for (Module module : modules) {
//			jsarray.push(module.getName());
//		}
//		delegate.bootstrap(jsarray);
		GWT.log("bootstrapping " + module.getName());
		delegate.bootstrap(module.getName());
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
	
	final native void bootstrap(String module) /*-{
		this.bootstrap($doc, [ module ]);
	}-*/;
}
interface ModuleCreator<T extends Module> extends Creator<T> {
}