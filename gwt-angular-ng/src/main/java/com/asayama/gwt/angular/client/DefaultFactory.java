package com.asayama.gwt.angular.client;

import com.google.gwt.core.client.GWT;

public class DefaultFactory<S extends Service> implements Factory<S> {

	static ServiceCreator SERVICE_CREATOR = GWT.create(ServiceCreator.class);
	final Class<S> klass;
	final String name;
	
	public DefaultFactory(Class<S> klass) {
		this.klass = klass;
		this.name = klass.getName();
	}
	
	@Override
	public S create() {
		return SERVICE_CREATOR.create(this.klass);
	}
	
	@Override
	public Class<S> getServiceClass() {
		return klass;
	}
	
	@Override
	public String getName() {
		return name;
	}
}
