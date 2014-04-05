package com.asayama.gwt.angular.client;

/**
 * Provides GWT Java interface for AngularJS's Module object. 
 * <p>
 * http://docs.angularjs.org/api/angular.Module
 * </p>
 * 
 * @author kyoken74
 */
public interface Module {
    
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
     * Configures a previously created service object. Use the {@link Configurator}
     * to configure the provider injected into the module.
     * 
     * @param klass Provider to be configured.
     * @param configurator Configures the provider.
     */
    <P extends Provider> Module config(Class<P> klass, Configurator<P> configurator);
    
    /**
     * Registers a service component with the module. The name of the component
     * is derived from the class name, e.g.
     * <pre>
     * // Derived name is "com.example.MyService".
     * factory(com.example.MyService.class);
     * </pre>
     */
    <S extends Service> Module factory(Class<S> klass);
    
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
