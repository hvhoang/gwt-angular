package com.asayama.gwt.angular.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public abstract class Module {

	ModuleJSO delegate;

	public <T extends Controller> T controller(Class<T> controllerClass) {
		final T controller = GWT.create(controllerClass);
		final Controller.Constructor ctor = (Controller.Constructor) controller;
		ctor._injectServices(this);
		delegate.controller(controllerClass.getName(), new Function.Proxy(new Function() {
			@Override
			public JavaScriptObject invoke(Object... args) {
				return ctor._get(controller);
			}
		}));
		return controller;
	}
	
	public <T extends Service> T factory(Class<T> serviceClass) {
		final T service = GWT.create(serviceClass);
		final Service.Constructor ctor = ((Service.Constructor) service);
		delegate.factory(serviceClass.getName(), new Function.Proxy(new Function() {
			@Override
			public JavaScriptObject invoke(Object... args) {
				return ctor._get(service);
			}
		}));
		return service;
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