package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.Closure;
import com.asayama.gwt.core.client.Function;
import com.asayama.gwt.core.client.JSClosure;
import com.asayama.gwt.core.client.JSFunction;

/**
 * Provide registers {@link Providers} with {@link Injector}.
 * <p>
 * http://docs.angularjs.org/api/auto/object/$provide
 * </p>
 * The documentation talks about many of these methods returning "registered
 * provider instance" but I do not know what that means. It seems that services
 * are instances of objects created by providers, and the providers appear to
 * be functions that return service instances, but I cannot figure out what
 * provider instance is. Could it be provider function?
 * 
 * @author kyoken74
 * @see AbstractModule
 */
public class Provide implements Service {
    
    NGProvide ngo;
    
    public <S extends Service> void provider(String name, Function<S> provider) {
        ngo.provider(name, JSFunction.create(provider));
    }
    
    public <S extends Service> void factory(String name, Function<S> $getFn) {
        ngo.factory(name, JSFunction.create($getFn));
    }
    
    public void service(String name, Closure constructor) {
        ngo.service(name, JSClosure.create(constructor));
    }
    
    public void value(String name, Object value) {
        ngo.value(name, value);
    }
    
    public void constant(String name, Object value) {
        ngo.constant(name, value);
    }
    
    /**
     * @return decorated service?
     */
    public <S extends Service> S decorator(String name, Function<S> decorator) {
        return ngo.decorator(name, JSFunction.create(decorator));
    }
}

@Bind("$provide")
class NGProvide extends NGObject {

    protected NGProvide() {
    }

    /**
     * @return registered provider instance?
     */
    final native <S extends Service> Object provider(String name, JSFunction<S> provider) /*-{
        return this.provider(name, provider);
    }-*/;
    
    /**
     * @return registered provider instance?
     */
    final native <S extends Service> Object factory(String name, JSFunction<S> $getFn) /*-{
        return this.provider(name, { $get: $getFn });
    }-*/;
    
    /**
     * @return registered provider instance?
     */
    final native <S extends Service> Object service(String name, JSClosure constructor) /*-{
        return this.service(name, constructor);
    }-*/;

    /**
     * @return registered provider instance?
     */
    final native Object value(String name, Object value) /*-{
        return this.value(name, value);
    }-*/;

    /**
     * @return registered provider instance?
     */
    final native Object constant(String name, Object value) /*-{
        return this.constant(name, value);
    }-*/;

    /**
     * @return decorated service?
     */
    final native <S extends Service> S decorator(String name, JSFunction<S> decorator) /*-{
        return this.decorator(name, decorator);
    }-*/;

}
