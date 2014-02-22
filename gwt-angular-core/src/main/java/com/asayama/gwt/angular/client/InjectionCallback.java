package com.asayama.gwt.angular.client;


public interface InjectionCallback<T extends Injectable> {
    void onInjection(T injectable);
}
