package com.asayama.gwt.angular.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public abstract class Module {
	
	ModuleJSO delegate;
	String name;
	
	public <T extends Controller> T controller(final String name, final T controller) {
		try {
			final Controller.Constructor ctor = (Controller.Constructor) controller;
			ctor._injectServices(this);
			delegate.controller(name, new Function.Proxy(new Function() {
				@Override
				public JavaScriptObject invoke(Object... args) {
					return ctor._getConstructor(controller);
				}
			}));
			return controller;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException(controller.getClass().getName()
					+ " must be created using GWT.create()");
		}
	}
	
	public <T extends Service> T factory(final String name, final T service) {
		try {
			final Service.Constructor ctor = ((Service.Constructor) service);
			delegate.factory(name, new Function.Proxy(new Function() {
				@Override
				public JavaScriptObject invoke(Object... args) {
					return ctor._get(service);
				}
			}));
			return service;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException(service.getClass().getName()
					+ " must be created using GWT.create()");
		}
	}
	
	public void config(Function function) {
		delegate.config(new Function.Proxy(function));
	}
	
	public String getName() {
		return delegate.getName();
	}
	
	public String[] getRequires() {
		JsArrayString jsarray = delegate.getRequires();
		String[] results = new String[jsarray.length()];
		for (int i = 0; i < jsarray.length(); i++) {
			results[i] = jsarray.get(i);
		}
		return results;
	}
	
	void setDelegate(ModuleJSO delegate) {
		this.delegate = delegate;
	}
}
class ModuleJSO extends JavaScriptObject {
	
	protected ModuleJSO() {
	}
	
	final native String getName() /*-{
		return this.name;
	}-*/;
	
	final native JsArrayString getRequires() /*-{
		return this.requires;
	}-*/;
	
	final native void config(Function.Proxy proxy) /*-{
		this.config(function () {
			proxy.@com.asayama.gwt.angular.client.Function.Proxy::invoke(Lcom/google/gwt/core/client/JsArray;)([]);
		});
	}-*/;
	
	final native void controller(String name, Function.Proxy proxy) /*-{
		this.controller(name, proxy.@com.asayama.gwt.angular.client.Function.Proxy::invoke(Lcom/google/gwt/core/client/JsArray;)([]));
	}-*/;
	
	final native void factory(String name, Function.Proxy proxy) /*-{
		this.factory(name, proxy.@com.asayama.gwt.angular.client.Function.Proxy::invoke(Lcom/google/gwt/core/client/JsArray;)([]));
	}-*/;
}