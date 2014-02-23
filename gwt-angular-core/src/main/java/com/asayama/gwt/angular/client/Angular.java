package com.asayama.gwt.angular.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSClosure;
import com.asayama.gwt.core.client.JSFunction;
import com.google.gwt.core.client.GWT;

/**
 * Provides GWT Java representation of AngularJS's angular object.
 * 
 * @author kyoken74
 */
public class Angular {
	
    static final Module[] MODULE_ARRAY = new Module[0];
    static List<Module> modules = new ArrayList<Module>();
    static Map<String, Module> index = new HashMap<String, Module>();
    
    public static Module[] modules() {
        return modules.toArray(MODULE_ARRAY);
    }
    
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
        return module(object.getClass().getName(), object, closure);
    }
    
	public static <T extends Module> T module(String name, T object, Closure closure) {
	    modules.add(object);
	    index.put(name, object);
		ModuleDependenciesFactory dependencies = GWT.create(ModuleDependenciesFactory.class);
		JSArray<String> requires = JSArray.create(dependencies.create(object));
		JSClosure jsclosure = JSClosure.create(closure);
		object.jso = _module(name, requires, jsclosure);
		return object;
	}
	
    public static void bootstrap() {
        bootstrap(modules());
    }
    
	public static void bootstrap(Module... modules) {
		String m = "";
        StringBuilder sb = new StringBuilder();
		JSArray<String> jsarray = JSArray.create();
		for (int i = 0; i < modules.length; i++) {
			jsarray.add(modules[i].getClass().getName());
            sb.append(i == 0 ? "" : ", ").append(modules[i].getClass().getName());
		}
		try {
		    GWT.log(m = "bootstrapping " + sb.toString());
			_bootstrap(jsarray);
		} catch (Exception e) {
			GWT.log("Exception while " + m, e);
		}
	}

	private static native JSModule _module(String name, JSArray<String> requires, JSFunction<?> ctor) /*-{
		return $wnd.angular.module(name, requires, ctor);
	}-*/;
	
	private static native void _bootstrap(JSArray<String> modules) /*-{
		$wnd.angular.bootstrap($doc, modules);
	}-*/;

}
