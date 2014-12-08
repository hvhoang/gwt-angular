package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.Injector.Inject;
import com.asayama.gwt.jsni.client.JSArray;

/**
 * Used to retrieve object instances.
 * <p>
 * http://docs.angularjs.org/api/auto/service/$injector
 * </p>
 * 
 * @author kyoken74
 * @see AbstractModule
 */
public class Injector implements Service {

    public @interface Inject {
	    String value();
	}

	NGInjector ngo;
    
    public <S extends Service> S get(Class<S> klass) {
        return ngo.getService(klass.getName());
    }
    
    public boolean has(String name) {
        return ngo.has(name);
    }
    
    /**
     * FIXME Unclear what this method does.
     */
    public void instantiate() {
        ngo.instantiate();
    }
    
    public String[] annotate() {
        return ngo.annotate().toArray(JSArray.STRING_ARRAY);
    }
    
}

@Injector.Inject("$injector")
class NGInjector extends NGObject {

    protected NGInjector() {
    }

    final native <S extends Service> S getService(String name) /*-{
        return this.get(name);
    }-*/;
    
    final native boolean has(String name) /*-{
        return this.has(name);
    }-*/;
    
    final native void instantiate() /*-{
        this.instantiate();
    }-*/;
    
    final native JSArray<String> annotate() /*-{
        return this.annotate();
    }-*/;

}