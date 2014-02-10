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
 * used with {@link CreatorGenerator}, which inspects the types eligible for
 * creation at compile time.
 * <p>
 * The decision to separate the code generator from the underlying classes was
 * made to work around a limitation in GWT, which prevents us from implementing
 * multiple JavaScriptObject extensions sharing an interface.
 * </p>
 * 
 * @author kyoken74
 *
 * @see CreatorGenerator
 * @param <T>
 */
interface Creator<T> {
	T create(Class<? extends T> klass);
	JSArray<Object> dependencies(Class<? extends T> klass);
}

interface ModuleCreator<T extends Module> extends Creator<T> {}

interface ProviderCreator<T extends Provider> extends Creator<T> {}

interface ServiceCreator<T extends Service> extends Creator<T> {}

interface ControllerCreator<T extends Controller> extends Creator<T> {}

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
	T create(Class<? extends T> klass);
    JSClosure binder(Class<? extends T> klass, T object);
}

interface ControllerBinder<T extends Controller> extends Binder<T> {}

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
	T create(Class<? extends T> klass);
    JSClosure injector(Class<? extends T> klass, T object);
}

interface ProviderInjector<T extends Provider> extends Injector<T> {}

interface ServiceInjector<T extends Service> extends Injector<T> {}

interface ControllerInjector<T extends Controller> extends Injector<T> {}
