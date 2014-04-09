package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Service;


public class Q implements Service {

    private NGQ ngo;

    public <T> Deferred<T> defer() {
        return ngo._defer();
    }
}

@Bind("$q")
class NGQ extends NGObject {

    protected NGQ() {
    }

    final native <T> Deferred<T> _defer() /*-{
        return this.defer();
    }-*/;

}
