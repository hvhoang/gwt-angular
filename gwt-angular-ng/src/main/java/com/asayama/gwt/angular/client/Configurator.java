package com.asayama.gwt.angular.client;

/**
 * Provides an interface for configuring a {@link Provider} implementations.
 * This interface is intended for use in conjunction with 
 * {@link AbstractModule#config(Class, Configurator)}.
 * 
 * @author kyoken74
 * @param <P> A provider type to be configured.
 * @see AbstractModule#config(Class, Configurator)
 */
public interface Configurator<P extends Provider<?>> {
    void configure(P provider);
}
