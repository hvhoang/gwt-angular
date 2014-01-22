package com.asayama.gwt.angular.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public abstract class Module {
	
	ModuleJSO delegate;
	String name;
	
	/**
	 * An instance of Module's derived type should be created using GWT.creat()
	 */
	protected Module() {
	}
	
	public <T extends Controller> T controller(final String name, final T controller) {
		try {
			final Controller.Constructor ctor = (Controller.Constructor) controller;
			ctor._injectServices(this);
			delegate.controller(name, new Function.Proxy<JS>(new Function<JS>() {
				@Override
				public JS invoke(JS jso) {
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
			delegate.factory(name, new Function.Proxy<JS>(new Function<JS>() {
				@Override
				public JS invoke(JS jso) {
					return ctor._getConstructor(service);
				}
			}));
			return service;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException(service.getClass().getName()
					+ " must be created using GWT.create()");
		}
	}
	
	public abstract <T extends Provider> void onProviderReady(T provider);
	
	public <T extends Provider> T config(final T provider) {
		try {
			final Provider.Constructor ctor = ((Provider.Constructor) provider);
			delegate.config(new Function.Proxy<JS>(new Function<JS>() {
				@Override
				public JS invoke(JS jso) {
					return ctor._getConstructor(provider, 
							new Function.Proxy<JS>(new Function<JS>() {
								@Override
								public JS invoke(JS jso) {
									onProviderReady(provider);
									return null;
								}
							})
						);
				}
			}));
			return provider;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException(provider.getClass().getName()
					+ " must be created using GWT.create()");
		}
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
	
	final native void config(Function.Proxy<JS> proxy) /*-{
		this.config(proxy.@com.asayama.gwt.angular.client.Function.Proxy::invoke(Lcom/asayama/gwt/angular/client/JS;)({}));
	}-*/;
	
	final native void controller(String name, Function.Proxy<JS> proxy) /*-{
		this.controller(name, proxy.@com.asayama.gwt.angular.client.Function.Proxy::invoke(Lcom/asayama/gwt/angular/client/JS;)({}));
	}-*/;
	
	final native void factory(String name, Function.Proxy<JS> proxy) /*-{
		this.factory(name, proxy.@com.asayama.gwt.angular.client.Function.Proxy::invoke(Lcom/asayama/gwt/angular/client/JS;)({}));
	}-*/;
}