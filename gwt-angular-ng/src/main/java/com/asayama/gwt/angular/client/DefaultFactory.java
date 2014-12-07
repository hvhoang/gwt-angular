package com.asayama.gwt.angular.client;

import com.google.gwt.core.client.GWT;

public class DefaultFactory<S extends Service> implements Factory<S> {

	private static ServiceCreator SERVICE_CREATOR = GWT.create(ServiceCreator.class);
	private final Class<S> klass;

	public DefaultFactory(Class<S> klass) {
		this.klass = klass;
	}
	
	@Override
	public S create() {
		return SERVICE_CREATOR.create(this.klass);
	}
	
	@Override
	public Class<S> getServiceClass() {
		return klass;
	}
}
