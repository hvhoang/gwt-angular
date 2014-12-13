package com.asayama.gwt.angular.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.jsni.client.Closure;
import com.asayama.gwt.jsni.client.JSArray;
import com.asayama.gwt.jsni.client.JSClosure;
import com.asayama.gwt.jsni.client.JSFunction;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides GWT Java representation of AngularJS's angular object.
 * 
 * @author kyoken74
 */
public class Angular {

    @Target(ElementType.TYPE)
    public @interface SupportedRootClass {
        Class<?> value();
    }
    
    private static final String CLASS = Angular.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    
    static final NGAngular ng = NGAngular.getInstance();
    static List<String> modules = new ArrayList<String>();
    static Map<String, Module> index = new HashMap<String, Module>();
    
    public static String[] modules() {
        return modules.toArray(EMPTY_STRING_ARRAY);
    }
    
    /**
     * Creates a module with dependency listed in the <code>requires</code>
     * parameter. If a module by the same name (i.e. the same class name
     * including the package name) has been registered, then the previous
     * registration is overridden.
     * <p>
     * If you wish to obtain a reference to a previously reigstered module,
     * then please use {@link #getModule(Module)} instead.
     * </p>
     * 
     * @param module
     * @param requires
     * @return
     */
    public static Module module(Module module, String... requires) {
        Closure closure = new Closure() {
            @Override
            public void exec(Object... args) {
                // noop
            }
        };
        return module(module, closure, requires == null ? EMPTY_STRING_ARRAY : requires);
    }
    
    public static Module getModule(Module module) {
        //TODO implement me
        throw new UnsupportedOperationException("This method has not yet been implemented");
    }

    /**
     * @deprecated Replaced by {@link #module(Module, String...)} since 0.0.72
     */
    @Deprecated
    public static Module moduleWithDependency(Module module, String... requires) {
        return module(module, requires);
    }

    public static Module module(Module module, Closure closure, String... requires) {
        String name = module.getClass().getName();
        modules.add(name);
        index.put(name, module);
        JSArray<String> jsrequires = requires == null ? null : JSArray.create(requires);
        JSClosure jsclosure = closure == null ? null : JSClosure.create(closure);
        module.bind(ng.module(name, jsrequires, jsclosure));
        LOG.log(Level.FINEST, "Angular.module(" + module.getClass().getName() + ")");
        return module;
    }

    public static void bootstrap() {
        ng.bootstrap(JSArray.create(modules()));
    }
}

class NGAngular extends JavaScriptObject {

    static native NGAngular getInstance() /*-{
        return $wnd.angular;
    }-*/;
    
    protected NGAngular() {
    }
    
    native final JSModule module(String name, JSArray<String> requires, JSFunction<?> ctor) /*-{
        return this.module(name, requires, ctor);
    }-*/;
    
    native final void bootstrap(JSArray<String> modules) /*-{
        this.bootstrap($doc, modules);
    }-*/;
}