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

    /**
     * This method is called for each of the inject fields. The descendants of
     * this abstract class should declare injectable fields as protected.
     * 
     * @param object
     *            injected object
     * @see Injectable
     */
    public abstract <T extends Injectable> void onInjection(T object);

    public <P extends Provider> P config(final P object) {

        @SuppressWarnings("unchecked")
        Class<P> klass = (Class<P>) object.getClass();
        final String name = klass.getName();
        ProviderDependencies<P> creator = GWT.create(ProviderDependencies.class);
        ProviderInjector<P> injector = GWT.create(ProviderInjector.class);

        JSClosure jsinjector = injector.injector(klass, object);

        Function<P> function = new Function<P>() {

            @Override
            public P function(Object... args) {
                String m = "";
                if (object instanceof NGObjectWrapper && args != null && args.length > 0) {
                    GWT.log(m = "calling " + name + ".wrap(NGObject)");
                    ((NGObjectWrapper) object).wrap((NGObject) args[0]);
                }
                try {
                    GWT.log(m = "calling " + getName() + ".onInjection(" + name + ")");
                    Module.this.onInjection(object);
                } catch (Exception e) {
                    GWT.log("Exception while " + m, e);
                }
                return object;
            }
        };
        JSArray<Object> dependencies = creator.dependencies(klass);
        JSFunction<P> constructor = _config(JSFunction.create(function), jsinjector);
        dependencies.add(constructor);
        delegate.config(dependencies);
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

    public <S extends Service> S factory(final S object) {

        @SuppressWarnings("unchecked")
        Class<S> klass = (Class<S>) object.getClass();
        final String name = klass.getName();
        ServiceDependencies<S> creator = GWT.create(ServiceDependencies.class);
        ServiceInjector<S> injector = GWT.create(ServiceInjector.class);

        JSClosure jsinjector = injector.injector(klass, object);

        Function<S> function = new Function<S>() {

            @Override
            public S function(Object... args) {
                String m = "";
                if (object instanceof NGObjectWrapper && args != null && args.length > 0) {
                    GWT.log(m = "calling " + name + ".wrap(NGObject)");
                    ((NGObjectWrapper) object).wrap((NGObject) args[0]);
                }
                try {
                    GWT.log(m = "calling " + getName() + ".onInjection(" + name + ")");
                    Module.this.onInjection(object);
                } catch (Exception e) {
                    GWT.log("Exception while " + m, e);
                }
                return object;
            }
        };
        JSArray<Object> dependencies = creator.dependencies(klass);
        JSFunction<S> constructor = _factory(JSFunction.create(function), jsinjector);
        dependencies.add(constructor);
        delegate.factory(name, dependencies);
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
        return controller(object.getClass().getName(), object);
    }

    public <C extends Controller> C controller(final String name, final C object) {

        @SuppressWarnings("unchecked")
        Class<C> klass = (Class<C>) object.getClass();
        ControllerDependencies<C> creator = GWT.create(ControllerDependencies.class);
        ControllerBinder<C> binder = GWT.create(ControllerBinder.class);
        ControllerInjector<C> injector = GWT.create(ControllerInjector.class);

        JSClosure jsbinder = binder.binder(klass, object);
        JSClosure jsinjector = injector.injector(klass, object);

        Closure closure = new Closure() {

            @Override
            public void closure(Object... args) {
                String m = "";
                try {
                    GWT.log(m = "calling " + name + ".onControllerLoad");
                    object.onControllerLoad();
                    GWT.log(m = "calling " + getName() + ".onInjection(" + name + ")");
                    Module.this.onInjection(object);
                } catch (Exception e) {
                    GWT.log("Exception while " + m, e);
                }
            }
        };
        JSClosure constructor = _controller(JSClosure.create(closure), jsinjector, jsbinder);
        JSArray<Object> dependencies = creator.dependencies(klass);
        dependencies.add(0, "$scope");
        dependencies.add(constructor);
        delegate.controller(name, dependencies);
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
