package com.asayama.gwt.angular.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public interface Function {

	JavaScriptObject invoke(Object... args);
	
	public static class Proxy {
		
		final Function delegate;
		final List<Object> args = new ArrayList<Object>();
		
		public Proxy(Function delegate) {
			this.delegate = delegate;
		}
		
		public JavaScriptObject invoke(JsArray<JavaScriptObject> jsarray) {
			Object[] array = jsarray == null ? new Object[0] : new Object[jsarray.length()];
			for (int i = 0; jsarray != null && i < jsarray.length(); i++) {
				JavaScriptObject jso = jsarray.get(i);
				array[i] = jso;
			}
			return delegate.invoke(array);
		}
	}
}
