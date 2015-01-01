package com.asayama.gwt.angular.client;



public abstract class AbstractController implements Controller {

    @Injector.Inject
    protected NGScope scope;
    
    @Override
    public void onControllerLoad() {
        //noop
    }
}
