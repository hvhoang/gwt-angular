package com.asayama.gwt.angular.client;


public interface Module {

    String getName();
    String[] requires();
    void bind(JSModule jso);

    Module value(String name, Object value);
    Module constant(String name, Object value);
    <F extends Filter> Module filter(Class<F> klass);
    <D extends Directive> Module directive(Class<D> klass);
    <P extends Provider> Module config(Class<P> klass, Configurator<P> configurator);
    <S extends Service> Module factory(Class<S> klass);
    <C extends Controller> Module controller(Class<C> klass);
}
