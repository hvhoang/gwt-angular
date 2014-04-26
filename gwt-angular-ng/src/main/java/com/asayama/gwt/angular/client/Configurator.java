package com.asayama.gwt.angular.client;


public interface Configurator<T extends Provider> {
    void configure(T provider);
}
