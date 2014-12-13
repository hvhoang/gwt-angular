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
import com.google.gwt.thirdparty.javascript.jscomp.FunctionInformationMap.Module;

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
     * Manually start up Angular application.
     * <p>
     * See also <a href="https://docs.angularjs.org/api/ng/function/angular.bootstrap">
     * https://docs.angularjs.org/api/ng/function/angular.bootstrap</a>
     * </p>
     */
    public static void bootstrap() {
        ngo.bootstrap(JSArray.create(modules.toArray(EMPTY_STRING_ARRAY)));
    }

    /**
     * Returns an injector object that can be used to retrieve services.
     * <p>
     * See also <a href="https://docs.angularjs.org/api/ng/function/angular.injector">
     * https://docs.angularjs.org/api/ng/function/angular.injector</a>
     * </p>
     */
    @SafeVarargs
    public static <M extends AbstractModule> Injector injector(Class<M>... modules) {
        List<String> names = new ArrayList<String>(modules.length);
        for (Class<?> klass : modules) {
            names.add(klass.getName());
        }
        return ngo.injector(JSArray.create(names.toArray(EMPTY_STRING_ARRAY)));
    }

    /**
     * @deprecated Replaced by {@link #module(Module, String...)} since 0.0.72
     */
    @Deprecated
    public static <M extends AbstractModule> M moduleWithDependency(M module, String... requires) {
        return module(module, requires);
    }

    /**
     * Registers a module with Angular framework, with module dependency listed 
     * in the <code>requires</code> parameter. If a module by the same name 
     * (i.e. the same class name including the package name) has already been 
     * registered, then the previous registration is overridden.
     * 
     * @param module An instance of this module.
     * @param requires Optional list of other module names this module depends on.
     */
    public static <M extends AbstractModule> M module(M module, String... requires) {
        return module(module, null, requires == null ? EMPTY_STRING_ARRAY : requires);
    }
    
    static <M extends AbstractModule> M module(M module, Closure closure, String... requires) {
        String name = module.getClass().getName();
        modules.add(name);
        JSArray<String> jsrequires = requires == null ? null : JSArray.create(requires);
        JSClosure jsclosure = closure == null ? null : JSClosure.create(closure);
        module.ngo = ngo.module(name, jsrequires, jsclosure);
        LOG.log(Level.FINEST, "Angular.module(" + module.getClass().getName() + ")");
        return module;
    }
}

class NGAngular extends JavaScriptObject {

    static native NGAngular getInstance() /*-{
        return $wnd.angular;
    }-*/;
    
    protected NGAngular() {
        // JavaScriptObject must have an empty protected default constructor
    }
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.bind
    
    /**
     * https://docs.angularjs.org/api/ng/function/angular.bootstrap
     */
    native final void bootstrap(JSArray<String> modules) /*-{
        this.bootstrap($doc, modules);
    }-*/;
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.copy

    // TODO https://docs.angularjs.org/api/ng/function/angular.element
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.equals
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.extend
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.forEach
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.fromJson
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.identity
    
    /**
     * https://docs.angularjs.org/api/ng/function/angular.injector
     */
    native final Injector injector(JSArray<String> modules) /*-{
        return this.injector(modules);
    }-*/;
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.isArray
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.isDate
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.isDefined
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.isElement
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.isFunction
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.isNumber
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.isObject
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.isString
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.isUndefined
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.lowercase

    /**
     * https://docs.angularjs.org/api/ng/function/angular.module
     */
    native final NGModule module(String name, JSArray<String> requires, JSFunction<?> ctor) /*-{
        return this.module(name, requires, ctor);
    }-*/;

    // TODO https://docs.angularjs.org/api/ng/function/angular.noop
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.reloadWithDebugInfo
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.toJson
    
    // TODO https://docs.angularjs.org/api/ng/function/angular.uppercase
}