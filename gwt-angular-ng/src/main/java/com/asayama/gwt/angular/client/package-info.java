/**
 * Provides GWT Java wrapper around AngularJS. This module contains the 
 * components in Angular's "ng" module, which is the core of AngularJS 
 * framework. The core module contains enough components to start building a
 * simple application.
 * <p>
 * In order to use the components in this module, the user must add the 
 * following inherit statements in his or code.
 * </p>
 * <pre>{@code
 * <inherits name="com.asayama.gwt.angular.Angular" />
 * }</pre>
 */
package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.Angular.SupportedRootClass;
import com.asayama.gwt.jsni.client.JSClosure;

/**
 * Provides interfaces for an object creator. This interface is intended to be
 * used with {@link DefaultInstantiableCreatorGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 */
interface Creator<T> {
    <X extends T> X create(Class<X> klass);
}

@SupportedRootClass(Filter.class)
interface FilterCreator extends Creator<Filter> {
    @Override
    public <X extends Filter> X create(Class<X> klass);
}

@SupportedRootClass(Directive.class)
interface DirectiveCreator extends Creator<Directive> {
    @Override
    public <X extends Directive> X create(Class<X> klass);
}

@SupportedRootClass(Provider.class)
interface ProviderCreator extends Creator<Provider<?>> {
    @Override
    public <X extends Provider<?>> X create(Class<X> klass);
}

@SupportedRootClass(Service.class)
interface ServiceCreator extends Creator<Service> {
    @Override
    public <X extends Service> X create(Class<X> klass);
}

@SupportedRootClass(Controller.class)
interface ControllerCreator extends Creator<Controller> {
    @Override
    public <X extends Controller> X create(Class<X> klass);
}

@SupportedRootClass(Runnable.class)
interface RunnableCreator extends Creator<Runnable> {
    @Override
    public <X extends Runnable> X create(Class<X> klass);
}

/**
 * Provides interfaces for an object creator. This interface is intended to be
 * used with {@link DependencyInspectorGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see DependencyInspectorGenerator
 * @param <T>
 */
interface DependencyInspector {
    String[] inspect(Class<?> klass);
}

@SupportedRootClass(Provider.class)
interface ProviderDependencyInspector extends DependencyInspector {
}

@SupportedRootClass(Service.class)
interface ServiceDependencyInspector extends DependencyInspector {
}

@SupportedRootClass(Controller.class)
interface ControllerDependencyInspector extends DependencyInspector {
}

@SupportedRootClass(Directive.class)
interface DirectiveDependencyInspector extends DependencyInspector {
}

@SupportedRootClass(Filter.class)
interface FilterDependencyInspector extends DependencyInspector {
}

/**
 * @since 0.1.1
 */
@SupportedRootClass(Runnable.class)
interface RunnableDependencyInspector extends DependencyInspector {
}

/**
 * Provides interfaces for an object binder. This interface is intended to be
 * used with {@link ScopeBinderFactoryGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see ScopeBinderFactoryGenerator
 * @param <T>
 */
interface ScopeBinderFactory<T> {
    JSClosure create(T object);
}

/**
 * Represents the ScopeBinder factory for Controllers. In AngularJS, during the
 * construction of Controller class, we assign view models to the scope, so that
 * they are accessible from the view (HTML). This factory generates this
 * construction method on behalf of the user.
 * 
 * @author kyoken74
 */
@SupportedRootClass(Controller.class)
interface ControllerScopeBinderFactory extends ScopeBinderFactory<Controller> {
    @Override
    public JSClosure create(Controller object);
}

/**
 * Provides interfaces for an object injector. This interface is intended to be
 * used with {@link BinderFactoryGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see BinderFactoryGenerator
 * @param <T>
 */
interface BinderFactory<T> {
    JSClosure create(T object);
}

@SuppressWarnings("rawtypes")
@SupportedRootClass(Provider.class)
interface ProviderBinderFactory extends BinderFactory<Provider> {
    @Override
    public JSClosure create(Provider object);
}

@SupportedRootClass(Service.class)
interface ServiceBinderFactory extends BinderFactory<Service> {
    @Override
    public JSClosure create(Service object);
}

@SupportedRootClass(Controller.class)
interface ControllerBinderFactory extends BinderFactory<Controller> {
    @Override
    public JSClosure create(Controller object);
}

@SupportedRootClass(Directive.class)
interface DirectiveBinderFactory extends BinderFactory<Directive> {
    @Override
    public JSClosure create(Directive object);
}

@SupportedRootClass(Filter.class)
interface FilterBinderFactory extends BinderFactory<Filter> {
    @Override
    public JSClosure create(Filter object);
}

/**
 * @since 0.1.1
 */
@SupportedRootClass(Runnable.class)
interface RunnableBinderFactory extends BinderFactory<Runnable> {
    @Override
    public JSClosure create(Runnable object);
}
