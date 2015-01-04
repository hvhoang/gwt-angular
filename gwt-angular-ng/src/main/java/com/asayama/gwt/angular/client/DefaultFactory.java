package com.asayama.gwt.angular.client;

import com.google.gwt.core.client.GWT;


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
