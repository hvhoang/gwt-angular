package com.asayama.gwt.angular.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
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
    
    protected static final NGAngular ngo = NGAngular.getInstance();
    protected static final List<String> modules = new ArrayList<String>();
    
    /**
     * @deprecated Replaced by {@link #module(Module, String...)} since 0.0.72
     */
    @Deprecated
    public static Module moduleWithDependency(Module module, String... requires) {
        return module(module, requires);
    }

    /**
     * Creates a module with dependency listed in the <code>requires</code>
     * parameter. If a module by the same name (i.e. the same class name
     * including the package name) has been registered, then the previous
     * registration is overridden.
     * 
     * @param module An instance of this module.
     * @param requires Optional list of other module names this module depends on.
     */
    public static Module module(Module module, String... requires) {
        return module(module, null, requires == null ? EMPTY_STRING_ARRAY : requires);
    }
    
    static Module module(Module module, Closure closure, String... requires) {
        String name = module.getClass().getName();
        modules.add(name);
        JSArray<String> jsrequires = requires == null ? null : JSArray.create(requires);
        JSClosure jsclosure = closure == null ? null : JSClosure.create(closure);
        module.bind(ngo.module(name, jsrequires, jsclosure));
        LOG.log(Level.FINEST, "Angular.module(" + module.getClass().getName() + ")");
        return module;
    }

    public static void bootstrap() {
        ngo.bootstrap(JSArray.create(modules.toArray(EMPTY_STRING_ARRAY)));
    }
    
    @SafeVarargs
    public static <M extends Module> Injector injector(Class<M>... modules) {
        List<String> names = new ArrayList<String>(modules.length);
        for (Class<?> klass : modules) {
            names.add(klass.getName());
        }
        return ngo.injector(JSArray.create(names.toArray(EMPTY_STRING_ARRAY)));
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
    
    native final Injector injector(JSArray<String> modules) /*-{
        return this.injector(modules);
    }-*/;
}