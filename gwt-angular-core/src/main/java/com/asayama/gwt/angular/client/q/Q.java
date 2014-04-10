package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.jsni.client.JSArray;


public class Q implements Service {

    private NGQ ngo;

    public <T> Deferred<T> defer() {
        return ngo.defer().cast();
    }

    public Promise<JSArray<?>> all(Promise<?>... promises) {
        return ngo.all(JSArray.create(promises));
    }
}

@Bind("$q")
class NGQ extends NGObject {

    protected NGQ() {
    }

    final native Deferred<?> defer() /*-{
        return this.defer();
    }-*/;

    final native Promise<JSArray<?>> all(JSArray<Promise<?>> jsarray) /*-{
        return this.all(jsarray);
    }-*/;
}
