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

import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSClosure;

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
    JSArray<Object> dependencies(T object);
}

interface ModuleDependenciesFactory extends DependenciesFactory<Module> {
}

interface ProviderDependenciesFactory extends DependenciesFactory<Provider> {
}

interface ServiceDependenciesFactory extends DependenciesFactory<Service> {
}

interface ControllerDependenciesFactory extends DependenciesFactory<Controller> {
}

/**
 * Provides interfaces for an object binder. This interface is intended to be
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
    JSClosure binder(T object);
}

interface ControllerBinderFactory extends BinderFactory<Controller> {
}

/**
 * Provides interfaces for an object injector. This interface is intended to be
 * used with {@link InjectorFactoryGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see InjectorFactoryGenerator
 * @param <T>
 */
interface InjectorFactory<T> {
    JSClosure injector(T object);
}

interface ProviderInjectorFactory extends InjectorFactory<Provider> {
}

interface ServiceInjectorFactory extends InjectorFactory<Service> {
}

interface ControllerInjectorFactory extends InjectorFactory<Controller> {
}
