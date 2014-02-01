package com.asayama.gwt.angular.client;

public interface Creator<T> {
	T create(Class<? extends T> klass);
}
