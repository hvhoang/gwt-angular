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
 * Provides abstract implementation of {@link Module}. See the javadoc comments
 * on {@link Module} for more details.
 * 
 * @author kyoken74
 */
public abstract class AbstractModule implements Module {

    JSModule jso;

    @Override
    public abstract void onModuleLoad();
    
    @Override
    public void bind(JSModule jso) {
        this.jso = jso;
    }

    @Override
    public String getName() {
        return jso.getName();
    }

    @Override
    public Module value(String name, Object value) {
        jso.value(name, value);
        return this;
    }

    @Override
    public Module constant(String name, Object value) {
        jso.constant(name, value);
        return this;
    }
    
    @Override
    public <F extends Filter> Module filter(Class<F> klass) {
        String className = Strings.simpleName(klass);
        String name = Strings.decapitalize(className);
        return filter(name, klass);
    }
    
    <F extends Filter> Module filter(String name, final Class<F> klass) {
        String[] dependencies = FilterDependencyInspector.INSTANCE.inspect(klass);
        jso.filter(name, JSArray.create(dependencies),
                JSFunction.create(new AbstractFilterWrapper() {
                    @Override
                    public JSFilter call(Object... args) {
                        this.filter = FilterCreator.INSTANCE.create(klass);
                        this.binder = FilterBinderFactory.INSTANCE.create(filter);
                        return super.call(args);
                    }
                }));
        return this;
    }

    @Override
    public <D extends Directive> Module directive(Class<D> klass) {
        String className = Strings.simpleName(klass);
        return directive(Strings.decapitalize(className), klass);
    }
    
    <D extends Directive> Module directive(final String name, final Class<D> klass) {
        String[] dependencies = DirectiveDependencyInspector.INSTANCE.inspect(klass);
        jso.directive(name, JSArray.create(dependencies),
                JSFunction.create(new AbstractDirectiveWrapper() {
                    @Override
                    public JSDirective call(Object... args) {
                        this.directive = DirectiveCreator.INSTANCE.create(klass);
                        directive.setName(name);
                        this.binder = DirectiveBinderFactory.INSTANCE.create(directive);
                        return super.call(args);
                    }
                }));
        return this;
    }

    @Override
    public <S extends Service> Module service(S service) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("This method is not yet implemented");
    }

    @Override
    public <S extends Service> Module service(Class<S> klass) {
        return factory(new DefaultFactory<S>(klass));
    }

    /**
     * Deprecated since 0.0.68
     */
    @Deprecated
    @Override
    public <S extends Service> Module factory(Class<S> klass) {
        return factory(new DefaultFactory<S>(klass));
    }

    @Override
    public <S extends Service> Module factory(final Factory<S> factory) {
        String name = factory.getServiceClass().getName();
        return factory(name, factory);
    }
    
    <S extends Service> Module factory(String name, final Factory<S> factory) {
        Function<Service> initializer = new Function<Service>() {
            @Override
            public Service call(Object... args) {
                Service service = factory.create();
                JSClosure binder = ServiceBinderFactory.INSTANCE.create(service);
                binder.apply(args);
                return service;
            }
        };
        String[] dependencies = ServiceDependencyInspector.INSTANCE.inspect(factory.getServiceClass());
        jso.factory(name, JSArray.create(dependencies), JSFunction.create(initializer));
        return this;
    }

    @Override
    public <P extends Provider<?>> Module config(final Class<P> klass, final Configurator<P> configurator) {
        Function<P> initializer = new Function<P>() {
            @Override
            public P call(Object... args) {
                P provider = ProviderCreator.INSTANCE.create(klass);
                JSClosure binder = ProviderBinderFactory.INSTANCE.create(provider);
                binder.apply(args);
                configurator.configure(provider);
                return provider;
            }
        };
        String[] dependencies = ProviderDependencyInspector.INSTANCE.inspect(klass);
        jso.config(JSArray.create(dependencies), JSFunction.create(initializer));
        return this;
    }
    
    @Override
    public <C extends Controller> Module controller(Class<C> klass) {
        return controller(klass.getName(), klass);
    }

    <C extends Controller> Module controller(final String name, final Class<C> klass) {
        Closure initializer = new Closure() {
            @Override
            public void exec(Object... args) {
                String m = "";
                try {

                    Controller controller = ControllerCreator.INSTANCE.create(klass);
                    if (controller == null) {
                        String message = "Unable to create " + name;
                        GWT.log(message, new IllegalStateException(message));
                    }
                    JSClosure scopeBinder = ControllerScopeBinderFactory.INSTANCE.create(controller);
                    if (scopeBinder == null) {
                        String message = "Unable to create binder for " + name;
                        GWT.log(message, new IllegalStateException(message));
                    }
                    JSClosure binder = ControllerBinderFactory.INSTANCE.create(controller);
                    if (binder == null) {
                        String message = "Unable to create injector for " + name;
                        GWT.log(message, new IllegalStateException(message));
                    }

                    m = "shifing args";
                    Object[] shiftedArgs = new Object[args.length - 1];
                    for (int i = 0; i < shiftedArgs.length; i++) {
                        shiftedArgs[i] = args[i + 1];
                    }
                    m = "binding args";
                    scopeBinder.apply(args);
                    m = "injecting shiftedArgs";
                    binder.apply(shiftedArgs);
                    GWT.log(m = name + ".onControllerLoad()");
                    controller.onControllerLoad();
                } catch (Exception e) {
                    GWT.log("Exception while " + m, e);
                }
            }
        };
        String[] d = ControllerDependencyInspector.INSTANCE.inspect(klass);
        JSArray<String> dependencies = JSArray.create(d);
        dependencies.unshift("$scope");
        jso.controller(name, dependencies, JSClosure.create(initializer));
        return this;
    }

    /**
     * <b>This is an experimental feature.</b>
     * <p>
     * Binds ClientBundle to the scope via controller pattern.
     * </p>
     */
    public <C extends ClientResources> Module resources(Class<C> klass) {
        String name = klass.getName();
        return resources(name, klass);
    }
    
    <C extends ClientResources> Module resources(final String name, final Class<C> klass) {
        Closure initializer = new Closure() {

            @Override
            public void exec(Object... args) {
                String m = "";
                try {
                    
                    ClientResources resources = ClientResourcesCreator.INSTANCE.create(klass);
                    GWT.log("WARNING: You are using an experimental feature of GWT Angular, Module.resources(). "
                        + "This method might be removed from fugure versions without notice.");
                    if (resources == null) {
                        String message = "Unable to create " + name;
                        GWT.log(message, new IllegalStateException(message));
                    }
                    JSClosure scopeBinder = ClientResourcesScopeBinderFactory.INSTANCE.create(resources);
                    if (scopeBinder == null) {
                        String message = "Unable to create binder for " + name + ". "
                            + "Are you using this resources class as a controller in "
                            + "your view? If not, you should extend ClientBundle "
                            + "instead.";
                        GWT.log(message, new IllegalStateException(message));
                    }
                    
                    m = "binding args";
                    scopeBinder.apply(args);
                } catch (Exception e) {
                    GWT.log("Exception while " + m, e);
                }
            }
        };
        String [] dependencies;
        {
            dependencies = new String[1];
            dependencies[0] = "$scope";
        }
        jso.controller(name, JSArray.create(dependencies), JSClosure.create(initializer));
        return this;
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
