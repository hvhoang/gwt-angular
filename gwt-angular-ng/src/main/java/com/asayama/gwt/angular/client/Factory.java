package com.asayama.gwt.angular.client;

public interface Factory<S extends Service> {
	S create();
	String getName();
}
