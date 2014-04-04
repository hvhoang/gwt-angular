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

import com.asayama.gwt.jsni.client.JSClosure;

/**
 * Provides interfaces for an object creator. This interface is intended to be
 * used with {@link DependenciesFactoryGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see DependenciesFactoryGenerator
 * @param <T>
 */
interface CreatorFactory<T> {
    <X extends T> X create(Class<X> klass);
}

interface ProviderCreatorFactory extends CreatorFactory<Provider> {
    @Override
    public <X extends Provider> X create(Class<X> klass);
}

interface ServiceCreatorFactory extends CreatorFactory<Service> {
    @Override
    public <X extends Service> X create(Class<X> klass);
}

interface ControllerCreatorFactory extends CreatorFactory<Controller> {
    @Override
    public <X extends Controller> X create(Class<X> klass);
}

/**
 * Provides interfaces for an object creator. This interface is intended to be
 * used with {@link DependenciesFactoryGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see DependenciesFactoryGenerator
 * @param <T>
 */
interface DependenciesFactory<T> {
    String[] create(T object);
}

interface ProviderDependenciesFactory extends DependenciesFactory<Provider> {
}

interface ServiceDependenciesFactory extends DependenciesFactory<Service> {
}

interface ControllerDependenciesFactory extends DependenciesFactory<Controller> {
}

interface DirectiveDependenciesFactory extends DependenciesFactory<Directive> {
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

interface ControllerScopeBinderFactory extends ScopeBinderFactory<Controller> {
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

interface ProviderBinderFactory extends BinderFactory<Provider> {
}

interface ServiceBinderFactory extends BinderFactory<Service> {
}

interface ControllerBinderFactory extends BinderFactory<Controller> {
}

interface DirectiveBinderFactory extends BinderFactory<Directive> {
}
