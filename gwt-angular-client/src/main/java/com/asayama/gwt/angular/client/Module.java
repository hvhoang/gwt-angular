package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.Invoker;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.shared.GWT;

public abstract class Module implements Wrapper<ModuleJSO> {
	
	ModuleJSO delegate;
	
	/**
	 * An instance of Module's derived type should be created using GWT.create()
	 */
	protected Module() {
	}
	
	/**
	 * This method is called for each of the inject fields. The descendants of
	 * this abstract class should declare injectable fields as protected.
	 * 
	 * @param object injected object
	 * @see Injectable
	 */
	public abstract <T extends Injectable> void onInjection(T object);
	
	public <T extends Controller> T controller(final String name, final T controller) {
		try {
			final Controller.Constructor ctor = (Controller.Constructor) controller;
			ctor._injectServices(this);
			delegate.controller(name, new Invoker(new Function<$>() {
				@Override
				public $ function($ jso) {
					return ctor.constructor(new Invoker(new Closure<$>() {
						@Override
						public void closure($ jso) {
							GWT.log("calling " + name + ".onControllerLoad");
							controller.onControllerLoad();
GWT.log("controller-->onInjection");
							onInjection(controller);
						}
					}));
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
			final Constructor ctor = (Constructor) service;
			delegate.factory(name, new Invoker(new Function<$>() {
				public $ function($ jso) {
					return ctor.constructor(new Invoker(new Function<$>() {
						@SuppressWarnings("unchecked")
						@Override
						public $ function($ jso) {
							if (service instanceof Wrapper) {
								((Wrapper<$>) service).set$(jso);
							}
GWT.log("factory-->onInjection");
							onInjection(service);
							return jso;
						}
					}));
				}
			}));
			return service;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException(service.getClass().getName()
					+ " must be created using GWT.create()");
		}
	}
	
	public <T extends Provider> T config(final T provider) {
		try {
			final Constructor ctor = (Constructor) provider;
			delegate.config(new Invoker(new Function<$>() {
				public $ function($ jso) {
					return ctor.constructor(new Invoker(new Closure<$>() {
						@SuppressWarnings("unchecked")
						@Override
						public void closure($ jso) {
							if (provider instanceof Wrapper) {
								((Wrapper<$>) provider).set$(jso);
							}
GWT.log("config-->onInjection");
							onInjection(provider);
						}
					}));
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

	// Wrapper Methods
	
	@Override
	public $ get$() {
		return delegate;
	}

	@Override
	public void set$(ModuleJSO delegate) {
		this.delegate = delegate;
	}
}
class ModuleJSO extends $ {
	
	protected ModuleJSO() {
	}
	
	final String getName() {
		return getString("name");
	}
	
	final native JsArrayString getRequires() /*-{
		return this.requires;
	}-*/;
	
	final native void config(Invoker invoker) /*-{
		this.config(invoker.@com.asayama.gwt.core.client.Invoker::invoke()());
	}-*/;
	
	final native void controller(String name, Invoker invoker) /*-{
		this.controller(name, invoker.@com.asayama.gwt.core.client.Invoker::invoke()());
	}-*/;
	
	final native void factory(String name, Invoker invoker) /*-{
		this.factory(name, invoker.@com.asayama.gwt.core.client.Invoker::invoke()());
	}-*/;
}