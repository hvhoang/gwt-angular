package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.annotations.Bind;

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
    
}

@Bind("$provide")
class NGProvide extends NGObject {

    protected NGProvide() {
    }

}
