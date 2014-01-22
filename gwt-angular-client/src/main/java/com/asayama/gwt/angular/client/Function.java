package com.asayama.gwt.angular.client;

import java.util.ArrayList;
import java.util.List;

public interface Function<T extends JS> {

	JS invoke(T jso);
	
	public static class Proxy<T extends JS> {
		
		final Function<T> delegate;
		final List<Object> args = new ArrayList<Object>();
		
		public Proxy(Function<T> delegate) {
			this.delegate = delegate;
		}
		
		public JS invoke(T jso) {
			return delegate.invoke(jso);
		}
	}
}
