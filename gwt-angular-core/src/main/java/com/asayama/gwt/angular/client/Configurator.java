package com.asayama.gwt.angular.client;


public interface Configurator<T extends Injectable> {
    void configure(T injectable);
}
