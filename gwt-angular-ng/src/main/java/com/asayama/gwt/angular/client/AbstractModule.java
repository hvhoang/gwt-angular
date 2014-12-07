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
    
    <F extends Filter> Module filter(String name, Class<F> klass) {
        String[] dependencies = FilterDependenciesFactory.INSTANCE.create(klass);
        //TODO #88 defer instantiation of filter object?
        Filter filter = FilterCreator.INSTANCE.create(klass);
        JSClosure binder = FilterBinderFactory.INSTANCE.create(filter);
        jso.filter(name, JSArray.create(dependencies),
                JSFunction.create(new FilterWrapper(binder, filter)));
        return this;
    }

    @Override
    public <D extends Directive> Module directive(Class<D> klass) {
        String className = Strings.simpleName(klass);
        return directive(Strings.decapitalize(className), klass);
    }
    
    <D extends Directive> Module directive(String name, Class<D> klass) {
        String[] dependencies = DirectiveDependenciesFactory.INSTANCE.create(klass);
        Directive directive = DirectiveCreator.INSTANCE.create(klass);
        directive.setName(name);
        JSClosure binder = DirectiveBinderFactory.INSTANCE.create(directive);
        jso.directive(name, JSArray.create(dependencies),
                JSFunction.create(new DirectiveWrapper(binder, directive)));
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
        // TODO Defer instantiation until the time of construction
        // https://github.com/kyoken74/gwt-angular/issues/41
    	// Need to inject dependency into the factory before invoking the
    	// creation method.
        final Service service = factory.create();
        String name = factory.getName();
        Function<Service> initializer = new Function<Service>() {

            @Override
            public Service call(Object... args) {
            	JSClosure binder = ServiceBinderFactory.INSTANCE.create(service);
                binder.apply(args);
                return service;
            }
        };
        String[] dependencies = ServiceDependenciesFactory.INSTANCE.create(factory.getServiceClass());
        jso.factory(name, JSArray.create(dependencies), JSFunction.create(initializer));
        return this;
    }

    @Override
    public <P extends Provider<?>> Module config(final Class<P> klass, final Configurator<P> configurator) {
        // TODO Review the sequence of events. Configuration should be able to
    	// alter the behavior of the factory function that is returned.
        final P provider = ProviderCreator.INSTANCE.create(klass);
        final JSClosure binder = ProviderBinderFactory.INSTANCE.create(provider);
        Function<P> initializer = new Function<P>() {

            @Override
            public P call(Object... args) {
                binder.apply(args);
                configurator.configure(provider);
                return provider;
            }
        };
        String[] dependencies = ProviderDependenciesFactory.INSTANCE.create(klass);
        jso.config(JSArray.create(dependencies), JSFunction.create(initializer));
        return this;
    }
    
    @Override
    public <C extends Controller> Module controller(Class<C> klass) {
        // TODO Defer instantiation until the time of construction
        // https://github.com/kyoken74/gwt-angular/issues/41
        return controller(klass.getName(), klass);
    }

    <C extends Controller> Module controller(final String name, Class<C> klass) {
        final Controller controller = ControllerCreator.INSTANCE.create(klass);
        if (controller == null) {
            String message = "Unable to create " + name;
            GWT.log(message, new IllegalStateException(message));
            return this;
        }
        final JSClosure scopeBinder = ControllerScopeBinderFactory.INSTANCE.create(controller);
        if (scopeBinder == null) {
            String message = "Unable to create binder for " + name;
            GWT.log(message, new IllegalStateException(message));
            return this;
        }
        final JSClosure binder = ControllerBinderFactory.INSTANCE.create(controller);
        if (binder == null) {
            String message = "Unable to create injector for " + name;
            GWT.log(message, new IllegalStateException(message));
            return this;
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
                    GWT.log(m = name + ".onControllerLoad()");
                    controller.onControllerLoad();
                } catch (Exception e) {
                    GWT.log("Exception while " + m, e);
                }
            }
        };
        String [] dependencies;
        {
            String[] d = ControllerDependenciesFactory.INSTANCE.create(klass);
            int len = d == null ? 0 : d.length;
            dependencies = new String[len + 1];
            dependencies[0] = "$scope";
            for (int i = 0; i < len; i++) {
                dependencies[i + 1] = d[i];
            }
        }
        jso.controller(name, JSArray.create(dependencies), JSClosure.create(initializer));
        return this;
    }

    /**
     * <b>This is an experimental feature.</b>
     * <p>
     * Binds ClientBundle to the scope via controller pattern.
     * </p>
     */
    public <C extends ClientResources> Module resources(Class<C> klass) {
        // TODO Defer instantiation until the time of construction
        // https://github.com/kyoken74/gwt-angular/issues/41
    	String name = klass.getName();
    	ClientResources resources = ClientResourcesCreator.INSTANCE.create(klass);
        return resources(name, resources);
    }
    
    Module resources(final String name, final ClientResources resources) {
    	GWT.log("WARNING: You are using an experimental feature of GWT Angular, Module.resources(). "
    			+ "This method might be removed from fugure versions without notice.");
        if (resources == null) {
            String message = "Unable to create " + name;
            GWT.log(message, new IllegalStateException(message));
            return this;
        }
        final JSClosure scopeBinder = ClientResourcesScopeBinderFactory.INSTANCE.create(resources);
        if (scopeBinder == null) {
            String message = "Unable to create binder for " + name + ". "
            		+ "Are you using this resources class as a controller in "
            		+ "your view? If not, you should extend ClientBundle "
            		+ "instead.";
            GWT.log(message, new IllegalStateException(message));
            return this;
        }
        Closure initializer = new Closure() {

            @Override
            public void exec(Object... args) {
                String m = "";
                try {
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
