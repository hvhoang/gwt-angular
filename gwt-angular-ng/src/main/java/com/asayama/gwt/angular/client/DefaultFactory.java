package com.asayama.gwt.angular.client;


public class DefaultFactory<S extends Service> implements Factory<S> {

	private final Class<S> klass;

	public DefaultFactory(Class<S> klass) {
		this.klass = klass;
	}
	
	@Override
	public S create() {
		return ServiceCreator.INSTANCE.create(this.klass);
	}
	
	@Override
	public Class<S> getServiceClass() {
		return klass;
	}
}
