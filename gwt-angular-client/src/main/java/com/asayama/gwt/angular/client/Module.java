package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.$;
import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.Invoker;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.shared.GWT;

interface ProviderCreator<T extends Provider> extends Creator<T> {
}
interface ServiceCreator<T extends Service> extends Creator<T> {
}
interface ControllerCreator<T extends Controller> extends Creator<T> {
}
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

	/*
	 * Controller Factory
	 */
	
	public <T extends Controller> T controller(Class<T> klass) {
		ControllerCreator<T> creator = GWT.create(ControllerCreator.class);
		return controller(klass.getName(), creator.create(klass));
	}

	public <T extends Controller> T controller(final String name, final T controller) {
		Closure<ScopeJSO> closure = new Closure<ScopeJSO>() {
			@Override
			public void closure(ScopeJSO scope) {
				String m = "";
				try {
					GWT.log(m = "calling " + getName() + ".onInjection(" + name + ")");
					Module.this.onInjection(controller);
				} catch (Exception e) {
					GWT.log("Exception while " + m, e);
				}
			}
		};
		Constructor ctor = (Constructor) controller;
		$ jsarray = ctor.constructor(new Invoker(closure));
		delegate.controller(name, jsarray);
		return controller;
	}

	/*
	 * Factory Factory
	 */
	
	public <T extends Service> T factory(Class<T> klass) {
		ServiceCreator<T> creator = GWT.create(ServiceCreator.class);
		return factory(klass.getName(), creator.create(klass));
	}

	public <T extends Service> T factory(final String name, final T service) {
		Function<$> function = new Function<$>() {
			@SuppressWarnings("unchecked")
			@Override
			public $ function($ jso) {
				String m = "";
				try {
					if (service instanceof Wrapper) {
						GWT.log(m = "calling " + name + ".setDelegate($)");
						((Wrapper<$>) service).setDelegate(jso);
					}
					GWT.log(m = "calling " + getName() + ".onInjection(" + name + ")");
					Module.this.onInjection(service);
				} catch (Exception e) {
					GWT.log("Exception while " + m, e);
				}
				return jso;
			}
		};
		Constructor ctor = (Constructor) service;
		$ jsarray = ctor.constructor(new Invoker(function));
		delegate.factory(name, jsarray);
		return service;
	}
	
	/*
	 * Provider Factory
	 */
	
	public <T extends Provider> T config(Class<T> klass) {
		ProviderCreator<T> creator = GWT.create(ProviderCreator.class);
		return config(creator.create(klass));
	}

	public <T extends Provider> T config(final T provider) {
		final String name = provider.getClass().getName();
		Closure<$> closure = new Closure<$>() {
			@SuppressWarnings("unchecked")
			@Override
			public void closure($ jso) {
				String m = "";
				try {
					if (provider instanceof Wrapper) {
						GWT.log(m = "calling " + provider.getClass().getName() + ".setDelegate($)");
						((Wrapper<$>) provider).setDelegate(jso);
					}
					GWT.log(m = "calling " + getName() + ".onInjection(" + name + ")");
					Module.this.onInjection(provider);
				} catch (Exception e) {
					GWT.log("Exception while " + m, e);
				}
			}
		};
		final Constructor ctor = (Constructor) provider;
		$ jsarray = ctor.constructor(new Invoker(closure));
		delegate.config(jsarray);
		return provider;
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
	public ModuleJSO getDelegate() {
		return delegate;
	}

	@Override
	public void setDelegate($ delegate) {
		this.delegate = delegate.cast();
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
		
	final native void factory(String name, $ jsarray) /*-{
		this.factory(name, jsarray);
	}-*/;
	
	final native void config($ jsarray) /*-{
		this.config(jsarray);
	}-*/;
	
	final native void controller(String name, $ jsarray) /*-{
		this.controller(name, jsarray);
	}-*/;

}
