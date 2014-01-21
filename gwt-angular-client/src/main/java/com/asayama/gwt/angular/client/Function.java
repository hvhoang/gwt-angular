package com.asayama.gwt.angular.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

public interface Function<R extends JavaScriptObject, T extends JavaScriptObject> {

	R invoke(T jso);
	
	public static class Proxy<R extends JavaScriptObject, T extends JavaScriptObject> {
		
		final Function<R,T> delegate;
		final List<Object> args = new ArrayList<Object>();
		
		public Proxy(Function<R,T> delegate) {
			this.delegate = delegate;
		}
		
		public R invoke(T jso) {
			return delegate.invoke(jso);
		}
	}
}
