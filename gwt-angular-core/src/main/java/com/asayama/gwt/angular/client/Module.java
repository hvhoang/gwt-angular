package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSClosure;
import com.asayama.gwt.core.client.JSFunction;
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
        ProviderDependenciesFactory dependencies = GWT.create(ProviderDependenciesFactory.class);
        ProviderInjectorFactory injector = GWT.create(ProviderInjectorFactory.class);
        Function<P> constructor = new Function<P>() {

            @Override
            public P function(Object... args) {
                if (callback != null) {
                    callback.onInjection(provider);
                }
                return provider;
            }
        };
        JSClosure jsinjector = injector.injector(provider);
        JSFunction<P> jsconstructor = _config(JSFunction.create(constructor), jsinjector);
        JSArray<Object> jsdependencies = dependencies.dependencies(provider);
        jsdependencies.add(jsconstructor);
        jso.config(jsdependencies);
        return provider;
    }

    private native <P extends Provider> JSFunction<P> _config(JSFunction<P> jsfunction, JSClosure jsinjector) /*-{
		return function() {
			var args = Array.prototype.slice.call(arguments, 0);
			if (jsinjector) {
				jsinjector.apply(null, args);
			}
			return jsfunction.apply(null, args);
		};
    }-*/;

    public <S extends Service> S factory(S service) {
        return factory(service.getClass().getName(), service);
    }
    
    public <S extends Service> S factory(String name, S service) {
        return factory(name, service, null);
    }
    
    public <S extends Service> S factory(String name, final S service, final InjectionCallback<S> callback) {
        ServiceDependenciesFactory dependencies = GWT.create(ServiceDependenciesFactory.class);
        ServiceInjectorFactory injector = GWT.create(ServiceInjectorFactory.class);
        Function<S> constructor = new Function<S>() {

            @Override
            public S function(Object... args) {
                if (callback != null) {
                    callback.onInjection(service);
                }
                return service;
            }
        };
        JSClosure jsinjector = injector.injector(service);
        JSFunction<S> jsconstructor = _factory(JSFunction.create(constructor), jsinjector);
        JSArray<Object> jsdependencies = dependencies.dependencies(service);
        jsdependencies.add(jsconstructor);
        jso.factory(name, jsdependencies);
        return service;
    }

    private native <S extends Service> JSFunction<S> _factory(JSFunction<S> jsfunction, JSClosure jsinjector) /*-{
		return function() {
			var args = Array.prototype.slice.call(arguments, 0);
			if (jsinjector) {
				jsinjector.apply(null, args);
			}
			return jsfunction.apply(null, args);
		};
    }-*/;

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
        ControllerDependenciesFactory dependencies = GWT.create(ControllerDependenciesFactory.class);
        ControllerBinderFactory binder = GWT.create(ControllerBinderFactory.class);
        ControllerInjectorFactory injector = GWT.create(ControllerInjectorFactory.class);
        Closure constructor = new Closure() {

            @Override
            public void closure(Object... args) {
                controller.onControllerLoad();
                if (callback != null) {
                    callback.onInjection(controller);
                }
            }
        };
        JSClosure jsbinder = binder.binder(controller);
        JSClosure jsinjector = injector.injector(controller);
        JSClosure jsconstructor = _controller(JSClosure.create(constructor), jsinjector, jsbinder);
        JSArray<Object> jsdependencies = dependencies.dependencies(controller);
        jsdependencies.add(0, "$scope");
        jsdependencies.add(jsconstructor);
        jso.controller(name, jsdependencies);
        return controller;
    }

    private native JSClosure _controller(JSClosure jsclosure, JSClosure jsinjector, JSClosure jsbinder) /*-{
		return function() {
			var args = Array.prototype.slice.call(arguments, 0);
			if (jsbinder) {
				jsbinder(args.shift());
			}
			if (jsinjector) {
				jsinjector.apply(null, args);
			}
			jsclosure.apply(null, args);
		};
    }-*/;

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

    final native void config(JavaScriptObject jsarray) /*-{
		this.config(jsarray);
    }-*/;

    final native void factory(String name, JavaScriptObject jsarray) /*-{
		this.factory(name, jsarray);
    }-*/;

    final native void controller(String name, JavaScriptObject jsarray) /*-{
		this.controller(name, jsarray);
    }-*/;

}
