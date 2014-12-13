package com.asayama.gwt.angular.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.jsni.client.Closure;
import com.asayama.gwt.jsni.client.Function;
import com.asayama.gwt.jsni.client.JSArray;
import com.asayama.gwt.jsni.client.JSClosure;
import com.asayama.gwt.jsni.client.JSFunction;
import com.asayama.gwt.util.client.Strings;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides abstract implementation of {@link Module}. See the javadoc comments
 * on {@link Module} for more details.
 * <p>
 * https://docs.angularjs.org/api/ng/type/angular.Module
 * </p>
 * 
 * @author kyoken74
 */
public abstract class AbstractModule implements Module {

    private static final String CLASS = AbstractModule.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);
    
    protected NGModule ngo;

    @Override
    public abstract void onModuleLoad();
    
    @Override
    public void bind(NGModule jso) {
        this.ngo = jso;
    }

    @Override
    public String getName() {
        return ngo.getName();
    }

    @Override
    public Module value(String name, Object value) {
        ngo.value(name, value);
        return this;
    }

    @Override
    public Module constant(String name, Object value) {
        ngo.constant(name, value);
        return this;
    }
    
    @Override
    public <F extends Filter> Module filter(Class<F> klass) {
        String className = Strings.simpleName(klass);
        String name = Strings.decapitalize(className);
        return filter(name, klass);
    }
    
    <F extends Filter> Module filter(final String name, final Class<F> klass) {
        String[] dependencies = FilterDependencyInspector.INSTANCE.inspect(klass);
        ngo.filter(name, JSArray.create(dependencies),
                JSFunction.create(new AbstractFilterWrapper() {
                    @Override
                    public JSFilter call(Object... args) {
                        this.filter = FilterCreator.INSTANCE.create(klass);
                        this.binder = FilterBinderFactory.INSTANCE.create(filter);
                        String m = "";
                        try {
                            LOG.log(Level.FINEST, m = klass.getName() + ".onFilterLoad()");
                            filter.onFilterLoad();
                        } catch (Exception e) {
                            LOG.log(Level.WARNING, "Exception while calling " + m, e);
                        }
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
        ngo.directive(name, JSArray.create(dependencies),
                JSFunction.create(new AbstractDirectiveWrapper() {
                    @Override
                    public JSDirective call(Object... args) {
                        this.directive = DirectiveCreator.INSTANCE.create(klass);
                        directive.setName(name);
                        this.binder = DirectiveBinderFactory.INSTANCE.create(directive);
                        String m = "";
                        try {
                            LOG.log(Level.FINEST, m = klass.getName() + ".onDirectiveLoad()");
                            directive.onDirectiveLoad();
                        } catch (Exception e) {
                            LOG.log(Level.WARNING, "Exception while calling " + m, e);
                        }
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
    
    <S extends Service> Module factory(final String name, final Factory<S> factory) {
        Function<Service> initializer = new Function<Service>() {
            @Override
            public Service call(Object... args) {
                String m = "";
                try {
                    LOG.log(Level.FINEST, m = factory.getClass().getName() + ".onFactoryLoad() " + factory.getServiceClass().getName());
                    factory.onFactoryLoad();
                } catch (Exception e) {
                    LOG.log(Level.WARNING, "Exception while calling " + m, e);
                }
                Service service = factory.create();
                JSClosure binder = ServiceBinderFactory.INSTANCE.create(service);
                binder.apply(args);
                return service;
            }
        };
        String[] dependencies = ServiceDependencyInspector.INSTANCE.inspect(factory.getServiceClass());
        ngo.factory(name, JSArray.create(dependencies), JSFunction.create(initializer));
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
                String m = "";
                try {
                    LOG.log(Level.FINEST, "configuring " + klass.getName());
                    configurator.configure(provider);
                } catch (Exception e) {
                    LOG.log(Level.WARNING, "Exception while " + m, e);
                }
                return provider;
            }
        };
        String[] dependencies = ProviderDependencyInspector.INSTANCE.inspect(klass);
        ngo.config(JSArray.create(dependencies), JSFunction.create(initializer));
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
                        LOG.log(Level.FINEST,message, new IllegalStateException(message));
                    }
                    JSClosure scopeBinder = ControllerScopeBinderFactory.INSTANCE.create(controller);
                    if (scopeBinder == null) {
                        String message = "Unable to create binder for " + name;
                        LOG.log(Level.FINEST,message, new IllegalStateException(message));
                    }
                    JSClosure binder = ControllerBinderFactory.INSTANCE.create(controller);
                    if (binder == null) {
                        String message = "Unable to create injector for " + name;
                        LOG.log(Level.FINEST,message, new IllegalStateException(message));
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
                    LOG.log(Level.FINEST,m = name + ".onControllerLoad()");
                    controller.onControllerLoad();
                } catch (Exception e) {
                    LOG.log(Level.FINEST,"Exception while " + m, e);
                }
            }
        };
        String[] d = ControllerDependencyInspector.INSTANCE.inspect(klass);
        JSArray<String> dependencies = JSArray.create(d);
        dependencies.unshift("$scope");
        ngo.controller(name, dependencies, JSClosure.create(initializer));
        return this;
    }
}

class NGModule extends JavaScriptObject {

    protected NGModule() {
    }

    // Methods
    
    /**
     * @param name service name
     * @param dependencies 
     * @param providerType Construction function for creating new instance of the service.
     */
    final native <S extends Service> NGModule provider(String name, JSArray<String> dependencies, JSFunction<S> providerType) /*-{
        dependencies.push(providerType);
        return this.provider(name, dependencies);
    }-*/;
    
    /**
     * @param name service name
     * @param dependencies
     * @param providerFunction Function for creating new instance of the service.
     */
    final native <S extends Service> NGModule factory(String name, JSArray<String> dependencies, JSFunction<S> providerFunction) /*-{
        dependencies.push(providerFunction);
        return this.factory(name, dependencies);
    }-*/;

    /**
     * @param name service name
     * @param dependencies
     * @param constructor A constructor function that will be instantiated.
     */
    final native <S extends Service> NGModule service(String name, JSArray<String> dependencies, JSFunction<S> constructor) /*-{
        dependencies.push(constructor);
        return this.factory(name, dependencies);
    }-*/;

    /**
     * @param name service name
     * @param object Service instance object.
     */
    final native NGModule value(String name, Object object) /*-{
        return this.value(name, object);
    }-*/;

    /**
     * @param name constant name
     * @param object Constant value.
     */
    final native NGModule constant(String name, Object object) /*-{
        return this.constant(name, object);
    }-*/;

    /**
     * TODO Implement this AbstractModule.animation()
     * <p>
     * Depends on "ngAnimate" module.
     * </p>
     * 
     * @param name animation name
     * @param animationFactory Factory function for creating new instance of an animation.
     */
    final native NGModule animation(String name, JSFunction<?> animationFactory) /*-{
        return this;
    }-*/;

    /**
     * @param name Filter name.
     * @param dependencies
     * @param filterFactory Factory function for creating new instance of filter.
     */
    final native NGModule filter(String name, JSArray<String> dependencies, JSFunction<JSFilter> filterFactory) /*-{
        dependencies.push(filterFactory);
        return this.filter(name, dependencies);
    }-*/;

    /**
     * @param name Controller name.
     * @param dependencies
     * @param constructor Controller constructor function.
     */
    final native NGModule controller(String name, JSArray<String> dependencies, JSClosure constructor) /*-{
        dependencies.push(constructor);
        return this.controller(name, dependencies);
    }-*/;
    
    /**
     * @param name Directive name.
     * @param dependencies
     * @param directiveFactory Factory function for creating new instance of directives.
     */
    final native NGModule directive(String name, JSArray<String> dependencies, JSFunction<JSDirective> directiveFactory) /*-{
        dependencies.push(directiveFactory);
        return this.directive(name, dependencies);
    }-*/;

    /**
     * @param dependencies
     * @param configFn Execute this function on module load. Useful for service configuration.
     */
    final native NGModule config(JSArray<String> dependencies, JavaScriptObject configFn) /*-{
        dependencies.push(configFn);
        return this.config(dependencies);
    }-*/;

    /**
     * @param initializationFn Execute this function after injector creation. Useful for application initialization.
     */
    final native NGModule run(JavaScriptObject initializationFn) /*-{
        return this.run(initializationFn);
    }-*/;
    
    // Properties
    
    /**
     * @return the list of modules which the injector will load before the current module is loaded.
     */
    final native JSArray<String> getRequires() /*-{
        return this.requires;
    }-*/;

    /**
     * @return Name of the module.
     */
    final native String getName() /*-{
        return this.name;
    }-*/;
}
