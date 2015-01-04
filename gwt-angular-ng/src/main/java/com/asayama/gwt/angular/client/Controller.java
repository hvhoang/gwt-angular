package com.asayama.gwt.angular.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.jsni.client.Closure;
import com.asayama.gwt.jsni.client.JSClosure;
import com.google.gwt.core.client.GWT;

public interface Controller {
    void onControllerLoad();
}

/**
 * Provides a bridge between GWT and AngularJS during module initialization.
 * <p>
 * During module initialization, controllers are registered to the module,
 * presenting the constructor of the controller. AngularJS expects the 
 * constructor to be provided as a JavaScript function, but during that
 * construction time, we want to perform some initialization of the object in
 * the GWT layer. This class enables us to perform the GWT tasks to be defined
 * as part of that constructor.
 * </p><p>
 * DefaultControllerContructor assumes that the first item in the dependency
 * is always "$scope", which was supplied by {@link AbstractModule}, and it
 * automatically binds the controller's properties and functions to the scope
 * according to the logic provided by {@link ControllerScopeBinderFactory}.
 * </p>
 * 
 * @author kyoken74
 * @param <C> Concrete implementation type of the Controller to be constructed.
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
            ControllerCreator creator = GWT.create(ControllerCreator.class);
            Controller controller = creator.create(klass);
            
            m = "creating scopeBinder for " + name;
            ControllerScopeBinderFactory scopeBinderFactory = GWT.create(ControllerScopeBinderFactory.class);
            JSClosure scopeBinder = scopeBinderFactory.create(controller);

            m = "creating binder for " + name;
            ControllerBinderFactory binderFactory = GWT.create(ControllerBinderFactory.class);
            JSClosure binder = binderFactory.create(controller);

            m = "shifing args";
            Object[] shiftedArgs = new Object[args.length - 1];
            for (int i = 0; i < shiftedArgs.length; i++) {
                shiftedArgs[i] = args[i + 1];
            }
            
            m = "binding args";
            scopeBinder.apply(args);
            
            m = "injecting shiftedArgs";
            if (binder != null) {
                binder.apply(shiftedArgs);
            }
            
            LOG.finest(m = name + ".onControllerLoad()");
            controller.onControllerLoad();
            
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Exception while " + m, e);
        }
    }
}