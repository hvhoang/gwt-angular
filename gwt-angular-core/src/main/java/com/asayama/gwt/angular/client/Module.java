package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.JSClosure;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.shared.GWT;

/**
 * Provides GWT Java representation of AngularJS's Module object.
 * <p>
 * http://docs.angularjs.org/api/angular.Module
 * </p>
 * 
 * @author kyoken74
 */
public abstract class Module {

    ProviderDependenciesFactory providerDependenciesFactory = GWT.create(ProviderDependenciesFactory.class);
    ProviderInjectorFactory providerInjectorFactory = GWT.create(ProviderInjectorFactory.class);
    ServiceDependenciesFactory serviceDependencyFactory = GWT.create(ServiceDependenciesFactory.class);
    ServiceInjectorFactory serviceInjectorFactory = GWT.create(ServiceInjectorFactory.class);
    ControllerDependenciesFactory controllerDependenciesFactory = GWT.create(ControllerDependenciesFactory.class);
    ControllerBinderFactory controllerBinderFactory = GWT.create(ControllerBinderFactory.class);
    ControllerInjectorFactory controllerInjectorFactory = GWT.create(ControllerInjectorFactory.class);

    JSModule jso;

    /**
     * An instance of Module's derived type should be created using GWT.create()
     */
    protected Module() {
    }

    public <P extends Provider> P config(P provider) {
        return config(provider, null);
    }

    public <P extends Provider> P config(final P provider, final InjectionCallback<P> callback) {
        final JSClosure injector = providerInjectorFactory.create(provider);
        Function<P> initializer = new Function<P>() {

            @Override
            public P function(Object... args) {
                injector.apply(args);
                if (callback != null) {
                    callback.onInjection(provider);
                }
                return provider;
            }
        };
        String[] dependencies = providerDependenciesFactory.create(provider);
        NGConstructor constructors = NGConstructor.create(initializer, dependencies);
        jso.config(constructors);
        return provider;
    }

    public <S extends Service> S factory(S service) {
        return factory(service.getClass().getName(), service);
    }
    
    public <S extends Service> S factory(String name, S service) {
        return factory(name, service, null);
    }
    
    public <S extends Service> S factory(String name, final S service, final InjectionCallback<S> callback) {
        final JSClosure injector = serviceInjectorFactory.create(service);
        Function<S> initializer = new Function<S>() {

            @Override
            public S function(Object... args) {
                injector.apply(args);
                if (callback != null) {
                    callback.onInjection(service);
                }
                return service;
            }
        };
        String[] dependencies = serviceDependencyFactory.create(service);
        NGConstructor constructor = NGConstructor.create(initializer, dependencies);
        jso.factory(name, constructor);
        return service;
    }

    public <C extends Controller> C controller(C controller) {
        return controller(controller, null);
    }
    
    public <C extends Controller> C controller(C controller, InjectionCallback<C> callback) {
        return controller(controller.getClass().getName(), controller, callback);
    }

    public <C extends Controller> C controller(String name, C object) {
        return controller(name, object, null);
    }
    
    public <C extends Controller> C controller(String name, final C controller, final InjectionCallback<C> callback) {
        final JSClosure binder = controllerBinderFactory.create(controller);
        final JSClosure injector = controllerInjectorFactory.create(controller);
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
                if (callback != null) {
                    callback.onInjection(controller);
                }
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

    public String[] getRequires() {
        JsArrayString jsarray = jso.getRequires();
        String[] results = new String[jsarray.length()];
        for (int i = 0; i < jsarray.length(); i++) {
            results[i] = jsarray.get(i);
        }
        return results;
    }
}

class JSModule extends JSObject {

    protected JSModule() {
    }

    final String getName() {
        return getString("name");
    }

    final native JsArrayString getRequires() /*-{
		return this.requires;
    }-*/;

    final native void config(JavaScriptObject constructor) /*-{
		this.config(constructor);
    }-*/;

    final native void factory(String name, JavaScriptObject constructor) /*-{
		this.factory(name, constructor);
    }-*/;

    final native void controller(String name, JavaScriptObject constructor) /*-{
		this.controller(name, constructor);
    }-*/;

}
