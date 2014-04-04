package com.asayama.gwt.angular.client;

import com.asayama.gwt.jsni.client.Closure;
import com.asayama.gwt.jsni.client.Function;
import com.asayama.gwt.jsni.client.JSArray;
import com.asayama.gwt.jsni.client.JSClosure;
import com.asayama.gwt.jsni.client.JSFunction;
import com.asayama.gwt.jsni.client.JSObject;
import com.asayama.gwt.util.client.Strings;
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

    private JSModule jso;

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
    
    public <F extends Filter> F filter(final F filter) {
        String className = Strings.simpleClassName(filter);
        return filter(Strings.decapitalize(className), filter);
    }
    
    public <F extends Filter> F filter(String name, F filter) {
        String[] dependencies = FilterDependenciesFactory.INSTANCE.create(filter);
        JSClosure binder = FilterBinderFactory.INSTANCE.create(filter);
        jso.filter(name, JSArray.create(dependencies),
                JSFunction.create(new FilterWrapper(binder, filter)));
        return filter;
    }

    //
    // Directive
    //
    
    public <D extends Directive> D directive(final D directive) {
        String className = Strings.simpleClassName(directive);
        return directive(Strings.decapitalize(className), directive);
    }
    
    public <D extends Directive> D directive(String name, final D directive) {
        if (directive == null) {
            return null;
        }
        directive.setName(name);
        String[] dependencies = DirectiveDependenciesFactory.INSTANCE.create(directive);
        JSClosure binder = DirectiveBinderFactory.INSTANCE.create(directive);
        jso.directive(name, JSArray.create(dependencies),
                JSFunction.create(new DirectiveWrapper(binder, directive)));
        return directive;
    }
    
    //
    // Provider
    //
    
    /**
     * Configures a previously created service object. Use the {@link Configurator}
     * to configure the provider injected into the module.
     * 
     * @param klass Provider to be configured.
     * @param configurator Configures the provider.
     */
    public <P extends Provider> P config(final Class<P> klass, final Configurator<P> configurator) {
        // TODO Defer instantiation until the time of construction
        // https://github.com/kyoken74/gwt-angular/issues/41
        final P provider = ProviderCreatorFactory.INSTANCE.create(klass);
        final JSClosure binder = ProviderBinderFactory.INSTANCE.create(provider);
        Function<P> initializer = new Function<P>() {

            @Override
            public P call(Object... args) {
                binder.apply(args);
                configurator.configure(provider);
                return provider;
            }
        };
        String[] dependencies = ProviderDependenciesFactory.INSTANCE.create(provider);
        jso.config(JSArray.create(dependencies), JSFunction.create(initializer));
        return provider;
    }

    //
    // Service
    //
    
    public <S extends Service> S factory(Class<S> klass) {
        return factory(klass.getName(), klass);
    }
    
    public <S extends Service> S factory(String name, final Class<S> klass) {
        // TODO Defer instantiation until the time of construction
        // https://github.com/kyoken74/gwt-angular/issues/41
        final S service = ServiceCreatorFactory.INSTANCE.create(klass);
        final JSClosure binder = ServiceBinderFactory.INSTANCE.create(service);
        Function<S> initializer = new Function<S>() {

            @Override
            public S call(Object... args) {
                binder.apply(args);
                return service;
            }
        };
        String[] dependencies = ServiceDependenciesFactory.INSTANCE.create(service);
        jso.factory(name, JSArray.create(dependencies), JSFunction.create(initializer));
        return service;
    }
    
    //
    // Controller
    //
    
    public <C extends Controller> C controller(Class<C> klass) {
        return controller(klass.getName(), klass);
    }

    public <C extends Controller> C controller(final String name, final Class<C> klass) {
        // TODO Defer instantiation until the time of construction
        // https://github.com/kyoken74/gwt-angular/issues/41
        final C controller = ControllerCreatorFactory.INSTANCE.create(klass);
        if (controller == null) {
            String message = "Unable to create " + klass.getName();
            GWT.log(message, new IllegalStateException(message));
            return controller;
        }
        final JSClosure scopeBinder = ControllerScopeBinderFactory.INSTANCE.create(controller);
        if (scopeBinder == null) {
            String message = "Unable to create binder for " + klass.getName();
            GWT.log(message, new IllegalStateException(message));
            return controller;
        }
        final JSClosure binder = ControllerBinderFactory.INSTANCE.create(controller);
        if (binder == null) {
            String message = "Unable to create injector for " + klass.getName();
            GWT.log(message, new IllegalStateException(message));
            return controller;
        }
        Closure initializer = new Closure() {

            @Override
            public void exec(Object... args) {
                String m = "";
                try {
                    m = "shifing args";
                    Object[] shiftedArgs = new Object[args.length - 1];
                    for (int i = 0; i < shiftedArgs.length; i++) {
                        shiftedArgs[i] = args[i + 1];
                    }
                    m = "binding args";
                    scopeBinder.apply(args);
                    m = "injecting shiftedArgs";
                    binder.apply(shiftedArgs);
                    GWT.log(m = klass.getName() + ".onControllerLoad()");
                    controller.onControllerLoad();
                } catch (Exception e) {
                    GWT.log("Exception while " + m, e);
                }
            }
        };
        String [] dependencies;
        {
            String[] d = ControllerDependenciesFactory.INSTANCE.create(controller);
            int len = d == null ? 0 : d.length;
            dependencies = new String[len + 1];
            dependencies[0] = "$scope";
            for (int i = 0; i < len; i++) {
                dependencies[i + 1] = d[i];
            }
        }
        jso.controller(name, JSArray.create(dependencies), JSClosure.create(initializer));
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
    
    final native void filter(String name, JSArray<String> dependencies, JSFunction<JSFilter> filter) /*-{
        dependencies.push(filter);
        this.filter(name, dependencies);
    }-*/;

    final native void directive(String name, JSArray<String> dependencies, JSFunction<JSDirective> directive) /*-{
        dependencies.push(directive);
        this.directive(name, dependencies);
    }-*/;

    final native void config(JSArray<String> dependencies, JavaScriptObject constructor) /*-{
        dependencies.push(constructor);
        this.config(dependencies);
    }-*/;
    
    final native <S extends Service> void factory(String name, JSArray<String> dependencies, JSFunction<S> constructor) /*-{
        dependencies.push(constructor);
        this.factory(name, dependencies);
    }-*/;
    
    final native void controller(String name, JSArray<String> dependencies, JSClosure constructor) /*-{
        dependencies.push(constructor);
        this.controller(name, dependencies);
    }-*/;
}
