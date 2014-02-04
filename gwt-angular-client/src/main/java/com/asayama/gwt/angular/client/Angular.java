package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.Invoker;
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
		
		Closure closure = new Closure() {
			@Override
			public void closure(Object... args) {
			}
		};

		//TODO Support module dependency
		object.delegate = _module(name, null, new Invoker(closure));
		return object;
	}
	
	public static void bootstrap(Module... modules) {
		String m = "";
		JsArrayString jsarray = (JsArrayString) JavaScriptObject.createArray();
		for (Module module : modules) {
			jsarray.push(module.getName());
		}
		try {
			GWT.log(m = "bootstrapping " + new Function<String>() {
				@Override
				public String function(Object... args) {
					String names = "";
					for (Object arg : args) {
						names += ((Module) arg).getName() + " ";
					}
					return names;
				}
			}.function((Object[]) modules));
			_bootstrap(jsarray);
		} catch (Exception e) {
			GWT.log("Exception while " + m, e);
		}
	}

	//TODO Support Creator.constructor method instead of the below method.
	private static native ModuleJSO _module(String name, JsArrayString requires, Invoker invoker) /*-{
		return $wnd.angular.module(name, [ "ngRoute", "ngSanitize" ], function () {
			invoker.@com.asayama.gwt.core.client.Invoker::invoke(Lcom/google/gwt/core/client/JsArray;)();
		});
	}-*/;
	
	private static native void _bootstrap(JsArrayString modules) /*-{
		$wnd.angular.bootstrap($doc, modules);
	}-*/;
	
}
