package com.asayama.gwt.angular.route.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Partial;
import com.asayama.gwt.angular.client.Provider;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.google.gwt.core.client.JavaScriptObject;

public class RouteProvider implements Provider {

    private NGRouteProvider ngo;

    @Deprecated
    public RouteProvider when(String route, Template action) {
        ngo.when(route, action);
        return this;
    }

    public <C extends Controller> RouteProvider when(String route, Partial partial, Class<C> controllerClass) {
        Template template = Template.create(partial, controllerClass);
        ngo.when(route, template);
        return this;
    }

    public RouteProvider when(String route, Redirect action) {
        ngo.when(route, action);
        return this;
    }

    public RouteProvider otherwise(Template action) {
        ngo.otherwise(action);
        return this;
    }

    public RouteProvider otherwise(Redirect action) {
        ngo.otherwise(action);
        return this;
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
