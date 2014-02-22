package com.asayama.gwt.angular.route.client;

import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.NGObjectWrapper;
import com.asayama.gwt.angular.client.Provider;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.google.gwt.core.client.JavaScriptObject;

public class RouteProvider implements Provider, NGObjectWrapper<NGRouteProvider> {

    protected NGRouteProvider ngo;

    public RouteProvider when(String route, Template action) {
        getNGObject().when(route, action);
        return this;
    }

    public RouteProvider when(String route, Redirect action) {
        getNGObject().when(route, action);
        return this;
    }

    public RouteProvider otherwise(Template action) {
        getNGObject().otherwise(action);
        return this;
    }

    public RouteProvider otherwise(Redirect action) {
        getNGObject().otherwise(action);
        return this;
    }

    @Override
    public void wrap(NGObject ngo) {
        this.ngo = NGObject.cast(ngo);
    }

    @Override
    public NGRouteProvider getNGObject() {
        return ngo;
    }
}

@Bind("$routeProvider")
class NGRouteProvider extends NGObject {

    protected NGRouteProvider() {
    }

    final native void when(String route, JavaScriptObject action) /*-{
		this.when(route, action);
    }-*/;

    final native void otherwise(JavaScriptObject action) /*-{
		this.otherwise(action);
	}-*/;
}
