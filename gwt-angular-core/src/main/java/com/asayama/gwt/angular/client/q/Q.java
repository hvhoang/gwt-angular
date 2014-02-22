package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSObject;

public class Q implements Service {

    protected NGQ ngo;

    public <T extends JSObject> Deferred defer() {
        Deferred deferred = new Deferred();
        deferred.jso = ngo._defer();
        return deferred;
    }
}

@Bind("$q")
class NGQ extends NGObject {

    protected NGQ() {
    }

    final native JSDeferred _defer() /*-{
		return this.defer();
	}-*/;

}
