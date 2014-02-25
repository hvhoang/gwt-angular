package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.annotations.Bind;

/**
 * <p>
 * http://docs.angularjs.org/api/auto/service/$injector
 * </p>
 * 
 * @author kyoken74
 * @see Module
 */
public class Injector implements Service {

}

@Bind("$injector")
class NGInjector extends NGObject {

    protected NGInjector() {
    }

}