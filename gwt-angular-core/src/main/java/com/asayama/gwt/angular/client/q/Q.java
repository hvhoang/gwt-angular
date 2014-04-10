package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Service;


public class Q implements Service {

    private NGQ ngo;

    public <T> Deferred<T> defer() {
        return ngo.defer().cast();
    }
}

@Bind("$q")
class NGQ extends NGObject {

    protected NGQ() {
    }

    final native Deferred<?> defer() /*-{
        return this.defer();
    }-*/;

}
