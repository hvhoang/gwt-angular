package com.asayama.gwt.angular.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asayama.gwt.angular.client.Injector.Inject;
import com.asayama.gwt.jsni.client.Closure;
import com.asayama.gwt.jsni.client.JSArray;
import com.asayama.gwt.jsni.client.JSClosure;
import com.asayama.gwt.jsni.client.JSFunction;
import com.google.gwt.core.client.GWT;

/**
 * Provides GWT Java representation of AngularJS's angular object.
 * 
 * @author kyoken74
 */
public class Angular {

    /**
     * @deprecated Replaced by {@link Inject }
     */
    @Deprecated
    @Target(ElementType.FIELD)
    public @interface Bind {
        String value();
    }

    public @interface SupportedRootClass {
        Class<?> value();
    }
    
    static final Module[] MODULE_ARRAY = new Module[0];
    static List<Module> modules = new ArrayList<Module>();
    static Map<String, Module> index = new HashMap<String, Module>();
    
    public static Module[] modules() {
        return modules.toArray(MODULE_ARRAY);
    }
    
    public static Module module(Module module) {
        return moduleWithDependency(module);
    }

    public static Module moduleWithDependency(Module module, String... requires) {
        Closure closure = new Closure() {
            @Override
            public void exec(Object... args) {
                // noop
            }
        };
        return module(module, closure, requires);
    }

    public static Module module(Module module, Closure closure, String... requires) {
        return module(module.getClass().getName(), module, closure, requires);
    }

    public static Module module(String name, Module module, Closure closure, String... requires) {
        modules.add(module);
        index.put(name, module);
        JSArray<String> jsrequires = JSArray.create(requires);
        JSClosure jsclosure = JSClosure.create(closure);
        module.bind(_module(name, jsrequires, jsclosure));
        GWT.log("Angular.module(" + module.getClass().getName() + ")");
        return module;
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
            sb.append("\n").append(modules[i].getClass().getName());
        }
        try {
            GWT.log(m = "bootstrapping " + jsarray.size() + " modules" + sb.toString());
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
