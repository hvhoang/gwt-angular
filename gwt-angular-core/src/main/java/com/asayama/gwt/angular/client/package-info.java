/**
 * Provides interfaces and implementations for core components in AngularJS.
 * To overcome the challenges of bridging the gap between the programming
 * paradigms of JavaScript and Java, code generator is used to inspect types
 * at compile-time and build helper classes to provide the glue between the
 * JavaScript and Java.
 */
package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSClosure;

/**
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

/**
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

/**
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

interface ModuleCreator<T extends Module> extends Creator<T> {
}

interface ProviderCreator<T extends Provider> extends Creator<T> {
}

interface ProviderInjector<T extends Provider> extends Injector<T> {
}

interface ServiceCreator<T extends Service> extends Creator<T> {
}

interface ServiceInjector<T extends Service> extends Injector<T> {
}

interface ControllerCreator<T extends Controller> extends Creator<T> {
}

interface ControllerInjector<T extends Controller> extends Injector<T> {
}

interface ControllerBinder<T extends Controller> extends Binder<T> {
}
