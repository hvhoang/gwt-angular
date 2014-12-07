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
import com.google.gwt.core.client.GWT;

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

interface FilterCreator extends Creator<Filter> {
    static FilterCreator INSTANCE = GWT.create(FilterCreator.class);
    @Override
    <X extends Filter> X create(Class<X> klass);
}

interface DirectiveCreator extends Creator<Directive> {
    static DirectiveCreator INSTANCE = GWT.create(DirectiveCreator.class);
    @Override
    <X extends Directive> X create(Class<X> klass);
}

interface ProviderCreator extends Creator<Provider> {
    static ProviderCreator INSTANCE = GWT.create(ProviderCreator.class);
    @Override
    <X extends Provider> X create(Class<X> klass);
}

interface ServiceCreator extends Creator<Service> {
    static ServiceCreator INSTANCE = GWT.create(ServiceCreator.class);
    @Override
    <X extends Service> X create(Class<X> klass);
}

interface ControllerCreator extends Creator<Controller> {
    static ControllerCreator INSTANCE = GWT.create(ControllerCreator.class);
    @Override
    <X extends Controller> X create(Class<X> klass);
}

interface ClientResourcesCreator extends Creator<ClientResources> {
    static ClientResourcesCreator INSTANCE = GWT.create(ClientResourcesCreator.class);
    @Override
    <X extends ClientResources> X create(Class<X> klass);
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
    static ProviderDependencyInspector INSTANCE = GWT.create(ProviderDependencyInspector.class);
}

@SupportedRootClass(Service.class)
interface ServiceDependencyInspector extends DependencyInspector {
    static ServiceDependencyInspector INSTANCE = GWT.create(ServiceDependencyInspector.class);
}

@SupportedRootClass(Controller.class)
interface ControllerDependencyInspector extends DependencyInspector {
    static ControllerDependencyInspector INSTANCE = GWT.create(ControllerDependencyInspector.class);
}

@SupportedRootClass(Directive.class)
interface DirectiveDependencyInspector extends DependencyInspector {
    static DirectiveDependencyInspector INSTANCE = GWT.create(DirectiveDependencyInspector.class);
}

@SupportedRootClass(Filter.class)
interface FilterDependencyInspector extends DependencyInspector {
    static FilterDependencyInspector INSTANCE = GWT.create(FilterDependencyInspector.class);
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
    static ControllerScopeBinderFactory INSTANCE = GWT.create(ControllerScopeBinderFactory.class);
    @Override
    public JSClosure create(Controller object);
}

/**
 * Represents the ScopeBinder factory for ClientBundle, so that the resources
 * declared as ClientBundle are readily available to the view (HTML) in a 
 * similar way the view models are available to the view via Controllers.
 *  
 * In AngularJS, during the construction of Controller class, we assign view 
 * models to the scope, so that they are accessible from the view (HTML). This 
 * factory generates this construction method on behalf of the user.
 * 
 * WARNING:
 * ClientBundleScopeBinderFactory is unable to provide the proper binding for
 * ClientBundle classes when the application is run in classic DevMode.
 * 
 * @author kyoken74
 */
@SupportedRootClass(ClientResources.class)
interface ClientResourcesScopeBinderFactory extends ScopeBinderFactory<ClientResources> {
    static ClientResourcesScopeBinderFactory INSTANCE = GWT.create(ClientResourcesScopeBinderFactory.class);
    @Override
    public JSClosure create(ClientResources object);
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

@SupportedRootClass(Provider.class)
interface ProviderBinderFactory extends BinderFactory<Provider> {
    static ProviderBinderFactory INSTANCE = GWT.create(ProviderBinderFactory.class);
    @Override
    public JSClosure create(Provider object);
}

@SupportedRootClass(Service.class)
interface ServiceBinderFactory extends BinderFactory<Service> {
    static ServiceBinderFactory INSTANCE = GWT.create(ServiceBinderFactory.class);
    @Override
    public JSClosure create(Service object);
}

@SupportedRootClass(Controller.class)
interface ControllerBinderFactory extends BinderFactory<Controller> {
    static ControllerBinderFactory INSTANCE = GWT.create(ControllerBinderFactory.class);
    @Override
    public JSClosure create(Controller object);
}

@SupportedRootClass(Directive.class)
interface DirectiveBinderFactory extends BinderFactory<Directive> {
    static DirectiveBinderFactory INSTANCE = GWT.create(DirectiveBinderFactory.class);
    @Override
    public JSClosure create(Directive object);
}

@SupportedRootClass(Filter.class)
interface FilterBinderFactory extends BinderFactory<Filter> {
    static FilterBinderFactory INSTANCE = GWT.create(FilterBinderFactory.class);
    @Override
    public JSClosure create(Filter object);
}
