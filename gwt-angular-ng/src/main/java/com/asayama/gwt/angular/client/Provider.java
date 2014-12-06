package com.asayama.gwt.angular.client;

/**
 * Provider represents a constructor function which returns Service Factory.
 * Service Factories themselves are functions which create {@link Service}s.
 * 
 * @author kyoken74
 * @see Provide
 */
public interface Provider<S extends Service> extends Injectable {

	Factory<S> getFactory();
}
