package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

interface ModuleCreator<T extends Module> extends Creator<T> {
}
public class Angular {
	
	public static <T extends Module> T module(Class<T> klass) {
		Closure closure = new Closure() {
			@Override
			public void closure(Object... args) {
				//noop
			}
		};
		return module(klass, closure);
	}
	
	public static <T extends Module> T module(Class<T> klass, Closure closure) {
		ModuleCreator<T> creator = GWT.create(ModuleCreator.class);
		JsArrayString requires = creator.dependencies(klass).cast();
		JSObject ctor = creator.constructor(new Invoker(closure));
		String name = klass.getName();
		T object = creator.create(klass);
		object.delegate = _module(name, requires, ctor);
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
	private static native ModuleJSO _module(String name, JsArrayString requires, JSObject ctor) /*-{
		return $wnd.angular.module(name, requires, ctor);
	}-*/;
	
	private static native void _bootstrap(JsArrayString modules) /*-{
		$wnd.angular.bootstrap($doc, modules);
	}-*/;
	
}
