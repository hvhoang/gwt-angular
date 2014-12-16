package com.asayama.gwt.angular.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.Injector.Inject;
import com.asayama.gwt.jsni.client.Closure;
import com.asayama.gwt.jsni.client.Function;
import com.asayama.gwt.jsni.client.JSArray;
import com.asayama.gwt.jsni.client.JSClosure;
import com.asayama.gwt.jsni.client.JSFunction;
import com.asayama.gwt.util.client.Strings;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Provides GWT Java interface for AngularJS's Module object, and acts as an
 * adapter for GWT module (represented by the EntryPoint interface) and Angular
 * module (represented by the added interfaces in this class.
 * 
 * <p>
 * <a href="http://docs.angularjs.org/api/angular.Module">
 * http://docs.angularjs.org/api/angular.Module</a>
 * </p><p>
 * An Angular module represents a set of Angular components, such as controllers,
 * services, filters, and directives. In and of itself, module component does
 * not offer any added functionality. The task of registering various components
 * relevant to the module is done by implementing the <code>onModuleLoad()</code>
 * method.
 * </p><p>
 * It is recommended the code to be organized such that a single GWT module
 * represents a single Angular module. This will help the code organized, and
 * easier to understand, though this is not strictly enforced by the code. More
 * advanced users may create separate sets of GWT and Angular module hierarchies
 * and assemble them any way he wishes.
 * </p><p>
 * If you choose to mirror the GWT and Angular modules, then be sure to register
 * your implementation of your Module to the GWT module descriptor as an
 * entry point, e.g. com/example/app/MyModule.gwt.xml
 * <pre>{@code 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <module>
 *   <inherits name="com.google.gwt.user.User" />
 *   <inherits name="com.asayama.gwt.angular.NG" />
 *   <source path="client" />
 *   <entry-point class="com.example.app.client.MyModule" />
 * </module>
 * }</pre>
 * 
 * The corresponding MyModule class definition may look like
 * <pre>
 * // In this hypothetical example, the module consists of a constant named
 * // "pages", directive named "myHello", filter named "reverse", and two
 * // controllers, "com.exmaple.client.FooController" and 
 * // "com.example.client.BarController".
 * 
 * package com.example.app.client;
 * 
 * public class MyModule extends AbstractModule implements EntryPoint {
 *   public void onModuleLoad() {
 *     Angular.module(this);
 *     constant("pages", JSArray.create(new String[]{
 *       "Introduction", "Theory", "Design", "Implementation", 
 *       "Test Methods", "Test Results", "Analysis", "Reference"
 *     }));
 *     directive(MyHello.class);
 *     filter(Reverse.class);
 *     controller(FooController.class);
 *     controller(BarController.class);
 *   }
 * }
 * </pre>
 * 
 * Note that this module focuses on registering the components into a single
 * module, and is not concerned with building the user interface. The work of
 * building the user interface (or bootstrapping) should be the job of a GWT
 * module, and it is recommended that this is separated from the rest of the
 * Angular module hierarchy. For example, com/example/ui/MyEntryPoint.gwt.xml
 * <pre>{@code 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <module>
 *   <inherits name="com.google.gwt.user.User" />
 *   <inherits name="com.example.app.MyModule" />
 *   <source path="client" />
 *   <entry-point class="com.example.ui.client.MyEntryPoint" />
 * </module>
 * }</pre>
 * 
 * The corresponding MyEntryPoint class definition may look like
 * <pre>
 * package com.example.ui.client;
 * 
 * public class MyEntryPoint implements EntryPoint {
 *   public void onModuleLoad() {
 *     Angular.bootstrap();
 *   }
 * }
 * </pre>
 * 
 * If you follow this code organization convention, then the module dependency
 * declared with {@code <inherits>} statements in *.gwt.xml files will be
 * consistent with the Angular module dependency (i.e. "requires" property
 * in AngularJS). You should have only one entry point that bootstraps the user
 * interface per application.
 * <p>
 * Users should consider extending {@link AbstractModule} rather than directly
 * implementing this interface.
 * </p>
 * 
 * @author kyoken74
 */
public abstract class AbstractModule {

    private static final String CLASS = AbstractModule.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);
    
    /**
     * References to a JavaScriptObject representation known to the underlying
     * AngularJS framework.
     * 
     * @see Angular#module(AbstractModule, Closure, String...)
     */
    protected NGModule ngo;

    /**
     * TODO Implement this method
     * @param klass
     * @return
     */
    public <P extends Provider<?>> AbstractModule provider(Class<P> klass) {
        throw new UnsupportedOperationException("This method is not yet supoprted");
    }
    
    /**
     * @deprecated Replaced by {@link #service(Class)} since 0.0.68
     */
    @Deprecated
    public <S extends Service> AbstractModule factory(Class<S> klass) {
        return factory(new DefaultFactory<S>(klass));
    }

    /**
     * Registers a service object factory instance with the module, so that the 
     * service object is created by the factory if/when the service is 
     * requested. The method is useful if the service creation needs 
     * customization/configuration, e.g. the creation of the service depends on 
     * other resources. If you merely wish to create an object via 
     * <code>new</code> or <code>GWT.create()</code>, then there is a 
     * convenience method {@link AbstractModule#service(Class) } so you do not 
     * have to define or instantiate a custom factory.
     * 
     * @param factory An instance of Factory object that creates a Service object.
     */
    public <S extends Service> AbstractModule factory(final Factory<S> factory) {
        String name = factory.getServiceClass().getName();
        return factory(name, factory);
    }
    
    protected <S extends Service> AbstractModule factory(final String name, final Factory<S> factory) {
        Function<Service> initializer = new Function<Service>() {
            @Override
            public Service call(Object... args) {
                String m = "";
                try {
                    final String SNAME = factory.getServiceClass().getName();
                    LOG.log(Level.FINEST, m = "calling onFactoryLoad() for " + SNAME);
                    factory.onFactoryLoad();
                    m = "calling create() for " + SNAME;
                    Service service = factory.create();
                    m = "binding dependency to " + SNAME;
                    JSClosure binder = ServiceBinderFactory.INSTANCE.create(service);
                    binder.apply(args);
                    return service;
                } catch (Exception e) {
                    LOG.log(Level.WARNING, "Exception while " + m, e);
                    return null;
                }
            }
        };
        String[] dependencies = ServiceDependencyInspector.INSTANCE.inspect(factory.getServiceClass());
        ngo.factory(name, JSArray.create(dependencies), JSFunction.create(initializer));
        return this;
    }

    /**
     * Registers a Service class to the module. This method is equivalent to
     * <pre>
     * MyModule module = new MyModule();
     * {@code module.factory(new DefaultFactory<S>(MyService.class)); }
     * </pre>
     */
    public <S extends Service> AbstractModule service(Class<S> klass) {
        return factory(new DefaultFactory<S>(klass));
    }

    /**
     * Registers an instance of a Service object to the module. This method is
     * useful if the service object has already been instantiated by someone
     * else outside of Angular, so there is no benefit to deferring the 
     * instantiation of that object.
     * <p>
     * If you have defined your own Service type, and wish to let the framework
     * handle the instantiation, then use {@link #service(Class)} instead.
     * </p>
     * 
     * @see Factory
     * @see DefaultFactory
     */
    public <S extends Service> AbstractModule service(S service) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("This method is not yet implemented");
    }

    /**
     * Registers an object/data structure to the module. Objects registered by 
     * this method are accessible by services and controllers via {@link Inject}
     * annotation within the same module. For example,
     * <pre>
     * MyModule module = new MyModule();
     * Angular.module(module);
     * module.value("myValue", "Hello, World!");
     * module.service(MyService.class);
     * ...
     * class MyService implements Service {
     *   {@code @Injector.Inject("myValue") }
     *   String myValue; //injector assigns "Hello, World!"
     * }
     * </pre>
     * The concept of value in AngularJS is a useful way to manage objects 
     * that are of module scope. With GWT, however, we can accomplish the same 
     * thing by simply using the Java package name with {@code public static},
     * if the value is used exclusively in GWT. The method is nevertheless 
     * useful if your module is expected to be a hybrid of GWT and JavaScript.
     * 
     * @param name Name of the object.
     * @param object The instance of the object.
     */
    public AbstractModule value(String name, Object object) {
        ngo.value(name, object);
        return this;
    }

    /**
     * Registers an object/data structure to the module. Objects registered by 
     * this method are accessible by services and controllers via {@link Inject}
     * annotation within the same module, or to a module during configuration.
     * For example,
     * <pre>
     * MyModule module = new MyModule();
     * Angular.module(module);
     * module.constant("myConstant", "Hello, World!");
     * {@code module.configure(MyServiceProvider.class, Configurator<MyServiceProvider>()} {
     *   public void configure(MyServiceProvider provider) {
     *     //configure provider
     *   }
     * });
     * ...
     * class MyServiceProvider implements Provider {
     *   {@code @Injector.Inject("myConstant") }
     *   String myConstant; //injector assigns "Hello, World!"
     * }
     * </pre>
     * The concept of value in AngularJS is a useful way to manage objects 
     * that are of module scope. With GWT, however, we can accomplish the same 
     * thing by simply using the Java package name with {@code public static},
     * if the value is used exclusively in GWT. The method is nevertheless 
     * useful if your module is expected to be a hybrid of GWT and JavaScript.
     * 
     * @param name Name of the object.
     * @param object The instance of the object.
     */
    public AbstractModule constant(String name, Object value) {
        ngo.constant(name, value);
        return this;
    }
    
    // TODO Implement this method.
    //public <A extends Animation> Module animation(Factory<A>)
    
    /**
     * Registers a Filter type with the module. The name of the component is 
     * derived from the class name, e.g.
     * <pre>
     * // Derived name is "myFilter". Java package is omitted.
     * filter(com.example.MyFilter.class);
     * </pre>
     * 
     * @param klass Filter type
     */
    public <F extends Filter> AbstractModule filter(Class<F> klass) {
        String className = Strings.simpleName(klass);
        String name = Strings.decapitalize(className);
        JSFunction<NGFilter> filterFactory = JSFunction.create(new DefaultFilterFactory<F>(name, klass));
        JSArray<String> dependencies = JSArray.create(FilterDependencyInspector.INSTANCE.inspect(klass));
        ngo.filter(name, dependencies, filterFactory);
        return this;
    }
    
    /**
     * Registers a controller component with the module. The name of the 
     * component is derived from the class name, e.g.
     * <pre>
     * // Derived name is "com.example.MyController".
     * controller(com.example.MyController.class);
     * </pre>
     * 
     * @param klass Controller type.
     */
    public <C extends Controller> AbstractModule controller(Class<C> klass) {
        String name = klass.getName();
        JSClosure constructor = JSClosure.create(new DefaultControllerConstructor<C>(name, klass));
        JSArray<String> dependencies = JSArray.create(ControllerDependencyInspector.INSTANCE.inspect(klass));
        dependencies.unshift("$scope");
        ngo.controller(name, dependencies, constructor);
        return this;
    }

    /**
     * Registers a Directive type with the module. The name of the component is 
     * derived from the class name, e.g.
     * <pre>
     * // Derived name is "myDirective". Java package is omitted.
     * // Attribute directive usage is {@code <div data-my-directive> }
     * // Class directive usage is {@code <div class="my-directive"> }
     * // Element directive usage is {@code <my-directive> }
     * directive(com.example.MyDirective.class);
     * </pre>
     * 
     * @param Directive type.
     */
    public <D extends Directive> AbstractModule directive(Class<D> klass) {
        String className = Strings.simpleName(klass);
        String name = Strings.decapitalize(className);
        JSFunction<NGDirective> directiveFactory = JSFunction.create(new DefaultDirectiveFactory<D>(name, klass));
        JSArray<String> dependencies = JSArray.create(DirectiveDependencyInspector.INSTANCE.inspect(klass));
        ngo.directive(name, dependencies, directiveFactory);
        return this;
    }

    /**
     * Configures a provider prior to obtaining the factory from it. 
     * Use the {@link Configurator}  to configure the provider injected into 
     * the module.
     * 
     * @param klass Provider type to be configured at module initialization.
     * @param configuration Configures the provider.
     */
    public <P extends Provider<?>> AbstractModule config(final Class<P> klass, final Configurator<P> configurator) {
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

    // Properties
    
    /**
     * Returns the name of the module. Every Angular module must be registered
     * with Angular framework, and give a name at the time of the registration.
     * This ensures that only one instance of the module per name exists at
     * runtime. See {@link Angular } class methods for more details.
     */
    public String getName() {
        return ngo.getName();
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
     * Registers a value object as a service to the module.
     * 
     * @param name service name
     * @param object Service instance object.
     */
    final native NGModule value(String name, Object object) /*-{
        return this.value(name, object);
    }-*/;

    /**
     * Registers a value object as a service to the module.
     * 
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
    final native NGModule filter(String name, JSArray<String> dependencies, JSFunction<NGFilter> filterFactory) /*-{
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
    final native NGModule directive(String name, JSArray<String> dependencies, JSFunction<NGDirective> directiveFactory) /*-{
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
