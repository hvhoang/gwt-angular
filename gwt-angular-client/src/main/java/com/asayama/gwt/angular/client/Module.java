package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.shared.GWT;

interface ProviderCreator<T extends Provider> extends Creator<T> {
}
interface ServiceCreator<T extends Service> extends Creator<T> {
}
interface ControllerCreator<T extends Controller> extends Creator<T> {
}
public abstract class Module implements Wrapper {
	
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

	protected <T extends Controller> T controller(final String name, final T controller) {
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
		Constructable ctor = (Constructable) controller;
		JSObject jsarray = ctor.construct(new Invoker(closure));
		delegate.controller(name, jsarray);
		return controller;
	}

	/*
	 * Factory Factory
	 */
	
	public <T extends Service> T factory(Class<T> klass) {
		
		ServiceCreator<T> creator = GWT.create(ServiceCreator.class);
		final T object = creator.create(klass);
		final String name = klass.getName();
		
		Closure<JSObject> closure = new Closure<JSObject>() {
			@Override
			public void closure(JSObject jso) {
				String m = "";
				if (object instanceof Wrapper) {
					GWT.log(m = "calling " + name + ".setDelegate(JSObject)");
					((Wrapper) object).wrap(jso);
				}
				try {
					GWT.log(m = "calling " + getName() + ".onInjection(" + name + ")");
					Module.this.onInjection(object);
				} catch (Exception e) {
					GWT.log("Exception while " + m, e);
				}
			}
		};
		
		JSObject jsarray = creator.construct(klass, new Invoker(closure));
		delegate.factory(name, jsarray);
		return object;
	}
	
	/*
	 * Provider Factory
	 */
	
	public <T extends Provider> T config(Class<T> klass) {
		
		ProviderCreator<T> creator = GWT.create(ProviderCreator.class);
		final T object = creator.create(klass);
		final String name = klass.getName();
		
		Closure<JSObject> closure = new Closure<JSObject>() {
			@Override
			public void closure(JSObject jso) {
				String m = "";
				if (object instanceof Wrapper) {
					GWT.log(m = "calling " + object.getClass().getName() + ".setDelegate(JSObject)");
					((Wrapper) object).wrap(jso);
				}
				try {
					GWT.log(m = "calling " + getName() + ".onInjection(" + name + ")");
					Module.this.onInjection(object);
				} catch (Exception e) {
					GWT.log("Exception while " + m, e);
				}
			}
		};
		
		JSObject jsarray = creator.construct(klass, new Invoker(closure));
		delegate.config(jsarray);
		return object;
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
	public void wrap(JSObject delegate) {
		this.delegate = delegate.cast();
	}

}
class ModuleJSO extends JSObject {
	
	protected ModuleJSO() {
	}
	
	final String getName() {
		return getString("name");
	}
	
	final native JsArrayString getRequires() /*-{
		return this.requires;
	}-*/;
		
	final native void factory(String name, JSObject jsarray) /*-{
		this.factory(name, jsarray);
	}-*/;
	
	final native void config(JSObject jsarray) /*-{
		this.config(jsarray);
	}-*/;
	
	final native void controller(String name, JSObject jsarray) /*-{
		this.controller(name, jsarray);
	}-*/;

}
