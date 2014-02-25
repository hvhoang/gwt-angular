package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSFunction;

/**
 * Provide registers {@link Providers} with {@link Injector}.
 * <p>
 * http://docs.angularjs.org/api/auto/object/$provide
 * </p>
 * 
 * @author kyoken74
 * @see Module
 */
public class Provide implements Service {
    
    NGProvide ngo;
    
    public void value(String name, String value) {
        ngo.value(name, value);
    }

    public void factory(String name, JSFunction<Service> initializer, String[] dependencies) {
        NGConstructor constructor = NGConstructor.create(initializer, dependencies);
        ngo.factory(name, constructor);
    }
}

@Bind("$provide")
class NGProvide extends NGObject {

    protected NGProvide() {
    }

    final native void value(String name, Object value) /*-{
        this.value(name, value);
    }-*/;
    
    final native void factory(String name, NGConstructor constructor) /*-{
        this.factory(name, constructor);
    }-*/;
}