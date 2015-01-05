package com.asayama.gwt.angular.client;

import com.google.gwt.core.client.GWT;

/**
 * Provides a default implementation of {@code Service} {@link Factory} 
 * interface. This implementation uses {@link ServiceCreator} class, which is a
 * generated class, to instantiate {@link Service} object. Services created 
 * this way are expected to support default constructor that is publicly 
 * visible.
 * 
 * @author kyoken74
 * @param <S> Service type to be created by this factory.
 * @see AbstractModule#service(Class)
 */
public class DefaultFactory<S extends Service> implements Factory<S> {

    private final Class<S> klass;

    public DefaultFactory(Class<S> klass) {
        this.klass = klass;
    }

    @Override
    public S create() {
        ServiceCreator creator = GWT.create(ServiceCreator.class);
        return creator.create(this.klass);
    }

    @Override
    public Class<S> getServiceClass() {
        return klass;
    }
    
    @Override
    public void onFactoryLoad() {
        // noop by default
    }
}
