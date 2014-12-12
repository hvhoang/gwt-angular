package com.asayama.gwt.angular.client;

/**
 * Provider represents a constructor function which returns Service Factory.
 * Service Factories themselves are functions which create {@link Service}s.
 * <p>
 * We do not have <code>onProviderLoad()</code> method. This is because we do
 * not want to have to extends the Provider classes just to configure it.
 * See <code>{@link Module#config(Class, Configurator)}</code> for configuring
 * Provider objects.
 * </p>
 * 
 * @author kyoken74
 * @see Provide
 * @see Module#config(Class, Configurator)
 */
public interface Provider<S extends Service> {

    Factory<S> getFactory();
}
