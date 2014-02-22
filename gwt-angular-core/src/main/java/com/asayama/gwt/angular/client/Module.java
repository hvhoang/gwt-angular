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

    JSModule delegate;

    /**
     * An instance of Module's derived type should be created using GWT.create()
     */
    protected Module() {
    }

    public <P extends Provider> P config(P object) {
        return config(object, null);
    }

    public <P extends Provider> P config(final P object, final InjectionCallback<P> callback) {
        ProviderDependencies dependencies = GWT.create(ProviderDependencies.class);
        ProviderInjector injector = GWT.create(ProviderInjector.class);
        Function<P> constructor = new Function<P>() {

            @Override
            public P function(Object... args) {
                if (callback != null) {
                    callback.onInjection(object);
                }
                return object;
            }
        };
        JSClosure jsinjector = injector.injector(object);
        JSArray<Object> jsdependencies = dependencies.dependencies(object);
        JSFunction<P> jsconstructor = _config(JSFunction.create(constructor), jsinjector);
        jsdependencies.add(jsconstructor);
        delegate.config(jsdependencies);
        return object;
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

    public <S extends Service> S factory(S object) {
        return factory(object.getClass().getName(), object);
    }
    
    public <S extends Service> S factory(String name, S object) {
        return factory(name, object, null);
    }
    
    public <S extends Service> S factory(String name, final S object, final InjectionCallback<S> callback) {
        ServiceDependencies dependencies = GWT.create(ServiceDependencies.class);
        ServiceInjector injector = GWT.create(ServiceInjector.class);
        Function<S> constructor = new Function<S>() {

            @Override
            public S function(Object... args) {
                if (callback != null) {
                    callback.onInjection(object);
                }
                return object;
            }
        };
        JSClosure jsinjector = injector.injector(object);
        JSArray<Object> jsdependencies = dependencies.dependencies(object);
        JSFunction<S> jsconstructor = _factory(JSFunction.create(constructor), jsinjector);
        jsdependencies.add(jsconstructor);
        delegate.factory(name, jsdependencies);
        return object;
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

    public <C extends Controller> C controller(C object) {
        return controller(object, null);
    }
    
    public <C extends Controller> C controller(C object, InjectionCallback<C> callback) {
        return controller(object.getClass().getName(), object, callback);
    }

    public <C extends Controller> C controller(String name, C object) {
        return controller(name, object, null);
    }
    
    public <C extends Controller> C controller(String name, final C object, final InjectionCallback<C> callback) {
        ControllerDependencies dependencies = GWT.create(ControllerDependencies.class);
        ControllerBinder binder = GWT.create(ControllerBinder.class);
        ControllerInjector injector = GWT.create(ControllerInjector.class);
        Closure constructor = new Closure() {

            @Override
            public void closure(Object... args) {
                object.onControllerLoad();
                if (callback != null) {
                    callback.onInjection(object);
                }
            }
        };
        JSClosure jsbinder = binder.binder(object);
        JSClosure jsinjector = injector.injector(object);
        JSClosure jsconstructor = _controller(JSClosure.create(constructor), jsinjector, jsbinder);
        JSArray<Object> jsdependencies = dependencies.dependencies(object);
        jsdependencies.add(0, "$scope");
        jsdependencies.add(jsconstructor);
        delegate.controller(name, jsdependencies);
        return object;
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
        return delegate.getName();
    }

    public String[] getRequires() {
        JsArrayString jsarray = delegate.getRequires();
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
