package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSClosure;
import com.asayama.gwt.core.client.JSFunction;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.shared.GWT;

/**
 * Provides GWT Java representation of AngularJS's Module object.
 * <p>
 * http://docs.angularjs.org/api/angular.Module
 * </p>
 * 
 * @author kyoken74
 */
public abstract class AbstractModule implements Module {

    JSModule jso;

    /**
     * Defines a value as a service to the module.
     * @param name Name by which to register the value with {@link Injector}
     * @param value Value object to register with {@link Injector}
     * @return Value object registered with {@link Injector}
     */
    public <V> V value(String name, V value) {
        jso.value(name, value);
        return value;
    }

    /**
     * Defines a value as a serive to the module.
     * @param name Name by which to register the value with {@link Injector}
     * @param value Value object to register with {@link Injector}
     * @return Value object registered with {@link Injector}
     */
    public <V> V constant(String name, V value) {
        jso.constant(name, value);
        return value;
    }
    
    //
    // Filter
    //
    
    public <F extends AbstractFilter> void filter(String name, F filter) {
        jso.filter(name, JSFunction.create(filter));
    }

    //
    // Directive
    //
    
    DirectiveDependenciesFactory directiveDependenciesFactory = GWT.create(DirectiveDependenciesFactory.class);
    DirectiveBinderFactory directiveBinderFactory = GWT.create(DirectiveBinderFactory.class);
    
    public <D extends Directive> D directive(String name, final D directive) {
        final JSClosure injector = directiveBinderFactory.create(directive);
        Function<D> initializer = new Function<D>() {

            @Override
            public D function(Object... args) {
                injector.apply(args);
                return directive;
            }
        };
        String[] dependencies = directiveDependenciesFactory.create(directive);
        NGConstructor constructor = NGConstructor.create(initializer, dependencies);
        jso.directive(name, constructor);
        return directive;
    }
    
    //
    // Provider
    //
    
    ProviderDependenciesFactory providerDependenciesFactory = GWT.create(ProviderDependenciesFactory.class);
    ProviderBinderFactory providerBinderFactory = GWT.create(ProviderBinderFactory.class);

    /**
     * Configures a previously created service object. Use the {@link Configurator}
     * to configure the provider injected into the module.
     * 
     * @param provider Provider to be configured.
     * @param configurator Configures the provider.
     */
    public <P extends Provider> P config(final P provider, final Configurator<P> configurator) {
        final JSClosure injector = providerBinderFactory.create(provider);
        Function<P> initializer = new Function<P>() {

            @Override
            public P function(Object... args) {
                injector.apply(args);
                configurator.configure(provider);
                return provider;
            }
        };
        String[] dependencies = providerDependenciesFactory.create(provider);
        NGConstructor constructor = NGConstructor.create(initializer, dependencies);
        jso.config(constructor);
        return provider;
    }

    //
    // Service
    //
    
    ServiceDependenciesFactory serviceDependencyFactory = GWT.create(ServiceDependenciesFactory.class);
    ServiceBinderFactory serviceBinderFactory = GWT.create(ServiceBinderFactory.class);
    
    public <S extends Service> S factory(S service) {
        return factory(service.getClass().getName(), service);
    }
    
    public <S extends Service> S factory(String name, final S service) {
        final JSClosure injector = serviceBinderFactory.create(service);
        Function<S> initializer = new Function<S>() {

            @Override
            public S function(Object... args) {
                injector.apply(args);
                return service;
            }
        };
        String[] dependencies = serviceDependencyFactory.create(service);
        NGConstructor constructor = NGConstructor.create(initializer, dependencies);
        jso.factory(name, constructor);
        return service;
    }
    
    //
    // Controller
    //
    
    ControllerDependenciesFactory controllerDependenciesFactory = GWT.create(ControllerDependenciesFactory.class);
    ControllerBinderFactory controllerBinderFactory = GWT.create(ControllerBinderFactory.class);
    ControllerScopeBinderFactory controllerScopeBinderFactory = GWT.create(ControllerScopeBinderFactory.class);

    public <C extends Controller> C controller(C controller) {
        return controller(controller.getClass().getName(), controller);
    }

    public <C extends Controller> C controller(String name, final C controller) {
        final JSClosure binder = controllerScopeBinderFactory.create(controller);
        final JSClosure injector = controllerBinderFactory.create(controller);
        Closure initializer = new Closure() {

            @Override
            public void closure(Object... args) {
                Object[] shiftedArgs = new Object[args.length - 1];
                for (int i = 0; i < shiftedArgs.length; i++) {
                    shiftedArgs[i] = args[i + 1];
                }
                binder.apply(args);
                injector.apply(shiftedArgs);
                controller.onControllerLoad();
            }
        };
        String [] dependencies;
        {
            String[] d = controllerDependenciesFactory.create(controller);
            dependencies = new String[d.length + 1];
            dependencies[0] = "$scope";
            for (int i = 0; i < d.length; i++) {
                dependencies[i + 1] = d[i];
            }
        }
        NGConstructor constructor = NGConstructor.create(initializer, dependencies);
        jso.controller(name, constructor);
        return controller;
    }

    public String getName() {
        return jso.getName();
    }

    public String[] requires() {
        return jso.requires().toArray(JSArray.STRING_ARRAY);
    }
    
    @Override
    public void bind(JSModule jso) {
        this.jso = jso;
    }

    @Override
    public String toString() {
        return getName();
    }
}

class JSModule extends JSObject {

    protected JSModule() {
    }

    final String getName() {
        return $string("name");
    }

    final native JSArray<String> requires() /*-{
		return this.requires;
    }-*/;
    
    final native void value(String name, Object value) /*-{
        this.value(name, value);
    }-*/;
    
    final native void constant(String name, Object value) /*-{
        this.constant(name, value);
    }-*/;
    
    final native void filter(String name, JSFunction<String> filter) /*-{
        this.filter(name, function() {
            return filter;
        });
    }-*/;

    final native void directive(String name, NGConstructor constructor) /*-{
        this.directive(name, constructor);
    }-*/;
    
    final native void config(JavaScriptObject constructor) /*-{
		this.config(constructor);
    }-*/;

    final native void factory(String name, NGConstructor constructor) /*-{
		this.factory(name, constructor);
    }-*/;

    final native void controller(String name, NGConstructor constructor) /*-{
		this.controller(name, constructor);
    }-*/;

}