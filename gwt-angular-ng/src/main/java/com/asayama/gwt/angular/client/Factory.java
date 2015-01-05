package com.asayama.gwt.angular.client;

/**
 * Provides an interface for {@link Service} factory.
 * 
 * @author kyoken74
 * @param <S> Service type of the object to be created by this factory.
 */
public interface Factory<S extends Service> {

    /**
     * Creates an instance of the Service.
     */
    S create();
    
    /**
     * Returns the class object representing the Service type of the object to 
     * be created by this factory.
     */
    Class<S> getServiceClass();
    
    /**
     * Invoked by the framework just prior to calling {@link #create()}.
     */
    void onFactoryLoad();
}
