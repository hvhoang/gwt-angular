package com.asayama.gwt.angular.client;

import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.Invoker;
import com.asayama.gwt.core.client.JSArray;
import com.asayama.gwt.core.client.JSFunction;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.core.shared.GWT;

interface ProviderCreator<T extends Provider> extends Creator<T> {}
interface ServiceCreator<T extends Service> extends Creator<T> {}
interface ControllerCreator<T extends Controller> extends Creator<T> {}

/**
 * Provides GWT Java representation of AngularJS's Module object.
 * 
 * @author kyoken74
 * @see http://docs.angularjs.org/api/angular.Module
 */
public abstract class Module {
	
	JSModule delegate;
	
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

	public <P extends Provider> P config(Class<P> klass) {
		
		ProviderCreator<P> creator = GWT.create(ProviderCreator.class);
		final P object = creator.create(klass);
		final String name = klass.getName();
		
		Function<P> function = new Function<P>() {
			@Override
			public P function(Object... args) {
				String m = "";
				if (object instanceof NGObjectWrapper && args != null && args.length > 0) {
					GWT.log(m = "calling " + name + ".wrap(NGObject)");
					((NGObjectWrapper) object).wrap((NGObject) args[0]);
				}
				try {
					GWT.log(m = "calling " + getName() + ".onInjection(" + name + ")");
					Module.this.onInjection(object);
				} catch (Exception e) {
					GWT.log("Exception while " + m, e);
				}
				return object;
			}
		};
		
		JSArray<Object> jsarray = creator.dependencies(klass);
		JSFunction<P> jsfunction = JSFunction.create(function);
		jsarray.add(jsfunction);
		delegate.config(jsarray);
		return object;
	}
	
	public <S extends Service> S factory(Class<S> klass) {
		
		ServiceCreator<S> creator = GWT.create(ServiceCreator.class);
		final S object = creator.create(klass);
		final String name = klass.getName();
		
		Function<S> function = new Function<S>() {
			@Override
			public S function(Object... args) {
				String m = "";
				if (object instanceof NGObjectWrapper && args != null && args.length > 0) {
					GWT.log(m = "calling " + name + ".wrap(NGObject)");
					((NGObjectWrapper) object).wrap((NGObject) args[0]);
				}
				try {
					GWT.log(m = "calling " + getName() + ".onInjection(" + name + ")");
					Module.this.onInjection(object);
				} catch (Exception e) {
					GWT.log("Exception while " + m, e);
				}
				return object;
			}
		};
		
		JSArray<Object> jsarray = creator.dependencies(klass);
		JSFunction<S> jsfunction = JSFunction.create(function);
		jsarray.add(jsfunction);
		delegate.factory(name, jsarray);
		return object;
	}
	
	public <C extends Controller> C controller(Class<C> klass) {
		ControllerCreator<C> creator = GWT.create(ControllerCreator.class);
		return controller(klass.getName(), creator.create(klass));
	}

	protected <C extends Controller> C controller(final String name, final C controller) {
		Closure closure = new Closure() {
			@Override
			public void closure(Object... args) {
				String m = "";
				try {
					GWT.log(m = "calling " + name + ".onControllerLoad");
					controller.onControllerLoad();
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

}
class JSModule extends JSObject {
	
	protected JSModule() {
	}
	
	final String getName() {
		return getString("name");
	}
	
	final native JsArrayString getRequires() /*-{
		return this.requires;
	}-*/;
		
	final native void config(JavaScriptObject jsarray) /*-{
		this.config(jsarray);
	}-*/;
	
	final native void factory(String name, JavaScriptObject jsarray) /*-{
		this.factory(name, jsarray);
	}-*/;
	
	final native void controller(String name, JavaScriptObject jsarray) /*-{
		this.controller(name, jsarray);
	}-*/;

}
