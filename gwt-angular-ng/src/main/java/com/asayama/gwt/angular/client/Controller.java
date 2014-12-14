package com.asayama.gwt.angular.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.jsni.client.Closure;
import com.asayama.gwt.jsni.client.JSClosure;

public interface Controller {
    void onControllerLoad();
}

/**
 * DefaultControllerContructor assumes that the first item in the dependency
 * is always "$scope", which was supplied by {@link AbstractModule}, and it
 * automatically binds the controller's properties and functions to the scope
 * according to the logic provided by {@link ControllerScopeBinderFactory}.
 * 
 * @author kyoken74
 * @param <C>
 */
class DefaultControllerConstructor<C extends Controller> extends Closure {
    
    private static final String CLASS = DefaultControllerConstructor.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);
    
    protected final String name;
    protected final Class<C> klass;
    
    DefaultControllerConstructor(String name, Class<C> klass) {
        this.name = name;
        this.klass = klass;
    }
    
    @Override
    public void exec(Object... args) {
        String m = "entering";
        try {
            m = "creating controller " + name;
            Controller controller = ControllerCreator.INSTANCE.create(klass);
            
            m = "creating scopeBinder for " + name;
            JSClosure scopeBinder = ControllerScopeBinderFactory.INSTANCE.create(controller);

            m = "creating binder for " + name;
            JSClosure binder = ControllerBinderFactory.INSTANCE.create(controller);

            m = "shifing args";
            Object[] shiftedArgs = new Object[args.length - 1];
            for (int i = 0; i < shiftedArgs.length; i++) {
                shiftedArgs[i] = args[i + 1];
            }
            
            m = "binding args";
            scopeBinder.apply(args);
            
            m = "injecting shiftedArgs";
            binder.apply(shiftedArgs);
            
            LOG.log(Level.FINEST, m = name + ".onControllerLoad()");
            controller.onControllerLoad();
            
        } catch (Exception e) {
            LOG.log(Level.FINEST, "Exception while " + m, e);
        }
    }
}