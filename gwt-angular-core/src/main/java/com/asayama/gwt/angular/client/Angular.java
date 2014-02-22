package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.JSClosure;
import com.asayama.gwt.core.client.JSFunction;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Provides GWT Java representation of AngularJS's angular object.
 * 
 * @author kyoken74
 */
public class Angular {
	
	public static <T extends Module> T module(T object) {
		Closure closure = new Closure() {
			@Override
			public void closure(Object... args) {
				//noop
			}
		};
		return module(object, closure);
	}
	
	public static <T extends Module> T module(T object, Closure closure) {
		@SuppressWarnings("unchecked")
        Class<T> klass = (Class<T>) object.getClass();
		ModuleDependencies<T> dependencies = GWT.create(ModuleDependencies.class);
		JsArrayString requires = dependencies.dependencies(klass).cast();
		JSClosure jsclosure = JSClosure.create(closure);
		String name = klass.getName();
		object.delegate = _module(name, requires, jsclosure);
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
					for (int i = 0; i < args.length; i++) {
					    Module arg = (Module) args[i];
					    if (i > 0) {
					        names += ", ";
					    }
						names += arg.getName();
					}
					return names;
				}
			}.function((Object[]) modules));
			_bootstrap(jsarray);
		} catch (Exception e) {
			GWT.log("Exception while " + m, e);
		}
	}

	private static native JSModule _module(String name, JsArrayString requires, JSFunction<?> ctor) /*-{
		return $wnd.angular.module(name, requires, ctor);
	}-*/;
	
	private static native void _bootstrap(JsArrayString modules) /*-{
		$wnd.angular.bootstrap($doc, modules);
	}-*/;

}
