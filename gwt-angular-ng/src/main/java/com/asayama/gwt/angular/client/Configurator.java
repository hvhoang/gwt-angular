package com.asayama.gwt.angular.client;


public interface Configurator<P extends Provider<?>> {
    void configure(P provider);
}
