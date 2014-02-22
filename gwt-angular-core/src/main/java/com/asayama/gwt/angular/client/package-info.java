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
 * used with {@link DependenciesGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see DependenciesGenerator
 * @param <T>
 */
interface Dependencies<T> {
    JSArray<Object> dependencies(T object);
}

interface ModuleDependencies extends Dependencies<Module> {
}

interface ProviderDependencies extends Dependencies<Provider> {
}

interface ServiceDependencies extends Dependencies<Service> {
}

interface ControllerDependencies extends Dependencies<Controller> {
}

/**
 * Provides interfaces for an object binder. This interface is intended to be
 * used with {@link BinderGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see BinderGenerator
 * @param <T>
 */
interface Binder<T> {
    JSClosure binder(T object);
}

interface ControllerBinder extends Binder<Controller> {
}

/**
 * Provides interfaces for an object injector. This interface is intended to be
 * used with {@link InjectorGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see InjectorGenerator
 * @param <T>
 */
interface Injector<T> {
    JSClosure injector(T object);
}

interface ProviderInjector extends Injector<Provider> {
}

interface ServiceInjector extends Injector<Service> {
}

interface ControllerInjector extends Injector<Controller> {
}
