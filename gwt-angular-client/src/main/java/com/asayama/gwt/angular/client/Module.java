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

	public <T extends Controller> T controller(Class<T> klass) {
		String name = klass.getName();
		ControllerCreator<T> creator = GWT.create(ControllerCreator.class);
		T controller = creator.create(klass);
		return controller(name, controller);
	}

	public <T extends Controller> T controller(final String name, final T controller) {
		try {
			final Constructor ctor = (Constructor) controller;
			$ jsarray = ctor.constructor(new Invoker(new Closure<ScopeJSO>() {
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
			}));
			delegate.controller(name, jsarray);
			/*
			delegate.controller(name, new Invoker(new Function<$>() {
				@Override
				public $ function($ jso) {
					return ctor.constructor(new Invoker(new Closure<ScopeJSO>() {
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
					}));
				}
			}));
			*/
			return controller;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException(controller.getClass().getName()
					+ " must be created using GWT.create()");
		}
	}

	public <T extends Service> T factory(Class<T> klass) {
		String name = klass.getName();
		ServiceCreator<T> creator = GWT.create(ServiceCreator.class);
		T service = creator.create(klass);
		return factory(name, service);
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
					}));
				}
			}));
			return service;
		} catch (ClassCastException e) {
			throw new UnsupportedOperationException(service.getClass().getName()
					+ " must be created using GWT.create()");
		}
	}
	
	public <T extends Provider> T config(Class<T> klass) {
		ProviderCreator<T> creator = GWT.create(ProviderCreator.class);
		T provider = creator.create(klass);
		return config(provider);
	}

	public <T extends Provider> T config(final T provider) {
		try {
			final String name = provider.getClass().getName();
			final Constructor ctor = (Constructor) provider;
			delegate.config(new Invoker(new Function<$>() {
				public $ function($ jso) {
					return ctor.constructor(new Invoker(new Closure<$>() {
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
	
	final native void config(Invoker invoker) /*-{
		this.config(invoker.@com.asayama.gwt.core.client.Invoker::invoke()());
	}-*/;
	
	final native void controller(String name, Invoker invoker) /*-{
		this.controller(name, invoker.@com.asayama.gwt.core.client.Invoker::invoke()());
	}-*/;
	
	final native void controller(String name, $ jsarray) /*-{
		this.controller(name, jsarray);
	}-*/;
	
	final native void factory(String name, Invoker invoker) /*-{
		this.factory(name, invoker.@com.asayama.gwt.core.client.Invoker::invoke()());
	}-*/;
}
