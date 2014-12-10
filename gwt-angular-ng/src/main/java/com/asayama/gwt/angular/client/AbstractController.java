package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.log.Log;


public abstract class AbstractController implements Controller {

    @Injector.Inject
    protected Log log;
    
    @Injector.Inject
    protected NGScope scope;
    
}
