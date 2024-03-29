package com.asayama.gwt.angular.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Used to retrieve object instances.
 * <p>
 * See also <a href="http://docs.angularjs.org/api/auto/service/$injector">
 * http://docs.angularjs.org/api/auto/service/$injector</a>
 * </p>
 * 
 * @author kyoken74
 * @see AbstractModule
 */
public class Injector implements Service {

    /**
     * Annotates the dependency of a component. Unlike AngularJS, which injects
     * the dependency into the constructor, GWT Angular assigns the dependency
     * to the properties of an object. For example, suppose a component named
     * 'fooController' depends on 'bar' in AngularJS.
     * <pre>
     * var myApp = angular.module('myApp', []);
     * myApp.controller('fooController', [ 'bar',
     *   function fooController(bar) {
     *     bar.baz();
     *   });
     * </pre>
     * Similar code can be written in GWT Angular as follows.
     * <pre>
     * public class FooController implements Controller {
     *   {@code @Injector.Inject} Bar bar;
     *   public void onControllerLoad() {
     *     bar.baz();
     *   }
     * }
     * 
     * public class MyApp extends AbstractModule implements EntryPoint {
     *   public void onModuleLoad() {
     *     Angular.module(this);
     *     this.controller(FooController.class);
     *   }
     * }
     * </pre>
     * 
     * @author kyoken74
     */
    @Target(ElementType.FIELD)
    public @interface Inject {
        String value() default "";
    }

    /**
     * Annotates the binding of native JavaScript objects to a JSNI 
     * representation of the same object in GWT. For example,
     * <pre>
     * {@code @Injector.Bind("$q")}
     * public class Q extends NGObject {
     *   protected Q() {
     *     //JavaScriptObject must have empty constructor
     *   }
     *   final native Deferred<?> defer()
     *     ...
     * }
     * </pre>
     * 
     * @author kyoken74
     */
    @Target(ElementType.TYPE)
    public @interface Bind {
        String value();
    }

    @Injector.Inject
    NGInjector ngo;
    
    public <S extends Service> S get(Class<S> klass) {
        return ngo.get(klass.getName(), null);
    }
    
    public boolean has(String name) {
        return ngo.has(name);
    }
}

@Injector.Bind("$injector")
class NGInjector extends JavaScriptObject {

    protected NGInjector() {
    }

    final native <S extends Service> S get(String name, String caller) /*-{
        return this.get(name, caller);
    }-*/;
    
    // TODO invoke(fn, [self], [locals]);
    
    final native boolean has(String name) /*-{
        return this.has(name);
    }-*/;
    
    // TODO instantiate(Type, [locals]);
    
    // TODO annotate(fn, [strictDi]);
}