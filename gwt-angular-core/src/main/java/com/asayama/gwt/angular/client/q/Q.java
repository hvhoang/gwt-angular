package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.core.client.JSObject;

public class Q implements Service, NGObjectWrapper<NGQ> {

    protected NGQ ngo;

    public <T extends JSObject> Deferred defer() {
        Deferred deferred = new Deferred();
        deferred.jso = getNGObject()._defer();
        return deferred;
    }

    @Override
    public void wrap(NGObject ngo) {
        this.ngo = NGObject.cast(ngo);
    }

    @Override
    public NGQ getNGObject() {
        return ngo;
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
