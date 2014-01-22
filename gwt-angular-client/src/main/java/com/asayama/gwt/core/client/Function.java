package com.asayama.gwt.core.client;

import java.util.ArrayList;
import java.util.List;

public interface Function<T extends $> {

	$ invoke(T jso);
	
	public static class Proxy<T extends $> {
		
		final Function<T> delegate;
		final List<Object> args = new ArrayList<Object>();
		
		public Proxy(Function<T> delegate) {
			this.delegate = delegate;
		}
		
		public $ invoke(T jso) {
			return delegate.invoke(jso);
		}
	}
}
