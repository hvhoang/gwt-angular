package com.asayama.gwt.angular.client;

import com.google.gwt.core.client.EntryPoint;

/**
 * Provides GWT Java interface for AngularJS's Module object, and acts as an
 * adapter for GWT module (represented by the EntryPoint interface) and Angular
 * module (represented by the added interfaces in this class.
 * 
 * <p>
 * http://docs.angularjs.org/api/angular.Module
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
 * public class MyModule extends AbstractModule {
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
 * public class MyEntryPoint extends EntryPoint {
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
 * @see AbstractModule
 */
public interface Module extends EntryPoint {

    /**
     * 
     */
    @Override
    public void onModuleLoad();
    
    /**
     * This method is used to bind the underlying AngularJS module object to
     * the Java wrapper.
     * <ul>
     * <li>https://github.com/kyoken74/gwt-angular/issues/64</li>
     * </ul>
     */
    void bind(JSModule jso);

    /**
     * Returns the name of the module. Every Angular module must be registered
     * with Angular framework, and give a name at the time of the registration.
     * This ensures that only one instance of the module per name exists at
     * runtime. See {@link Angular } class methods for more details.
     */
    String getName();

    /**
     * Defines a value as a service to the module.
     * @param name Name by which to register the value with {@link Injector}
     * @param value Value object to register with {@link Injector}
     * @return Value object registered with {@link Injector}
     */
    Module value(String name, Object value);

    /**
     * Defines a value as a service to the module.
     * @param name Name by which to register the value with {@link Injector}
     * @param value Value object to register with {@link Injector}
     * @return Value object registered with {@link Injector}
     */
    Module constant(String name, Object value);
    
    /**
     * Registers a filter component with the module. The name of the component
     * is derived from the class name, e.g.
     * <pre>
     * // Derived name is "myFilter". Java package is omitted.
     * filter(com.example.MyFilter.class);
     * </pre>
     */
    <F extends Filter> Module filter(Class<F> klass);
    
    /**
     * Registers a directive component with the module. The name of the 
     * component is derived from the class name, e.g.
     * <pre>
     * // Derived name is "myDirective". Java package is omitted.
     * // Attribute directive usage is {@code <div data-my-directive> }
     * // Class directive usage is {@code <div class="my-directive"> }
     * // Element directive usage is {@code <my-directive> }
     * directive(com.example.MyDirective.class);
     * </pre>
     */
    <D extends Directive> Module directive(Class<D> klass);
    
    /**
     * Registers a service object with the module. This method should be used
     * when the instance of the service already exists, so there is no benefit
     * to deferring the instantiation of the object.
     */
    <S extends Service> Module service(S service);
    
    /**
     * Registers a service class with the module, so that the service object is
     * created if/when it is requested. This method is equivalent to
     * <pre>
     * factory(new DefaultFactory(com.example.MyService.class));
     * </pre>
     */
    <S extends Service> Module service(Class<S> klass);
    
    /**
	 * Registers a service object factory with the module, so that the service
	 * object is created if/when it is requested. The method is useful if the
	 * service creation needs customization/configuration, e.g. the creation of
	 * the service depends on other resources. If you merely wish to create an
	 * object via <code>new</code> or <code>GWT.create()</code>, then there is
	 * a convenience method {@link Module#service(Class) }.
     */
    <S extends Service> Module factory(Factory<S> factory);
    
    /**
     * Configures a provider prior to obtaining the factory from it. 
     * Use the {@link Configurator}  to configure the provider injected into 
     * the module.
     * 
     * @param klass Provider to be configured.
     * @param configurator Configures the provider.
     */
    <P extends Provider<?>> Module config(Class<P> klass, Configurator<P> configurator);

    /**
     * Registers a controller component with the module. The name of the 
     * component is derived from the class name, e.g.
     * <pre>
     * // Derived name is "com.example.MyController".
     * factory(com.example.MyController.class);
     * </pre>
     */
    <C extends Controller> Module controller(Class<C> klass);
}
