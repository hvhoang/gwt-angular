package com.asayama.gwt.angular.route.client;

import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Partial;
import com.asayama.gwt.angular.client.Provider;
import com.asayama.gwt.angular.client.annotations.Bind;
import com.asayama.gwt.jsni.client.JSON;
import com.google.gwt.core.client.JavaScriptObject;

public class RouteProvider implements Provider {

    private NGRouteProvider ngo;

    public RouteProvider when(String route, Partial partial) {
        JSON json = JSON.create();
        json.put("templateUrl", partial.url());
        ngo.when(route, json);
        return this;
    }

    public <C extends Controller> RouteProvider when(String route, Partial partial, Class<C> controllerClass) {
        JSON json = JSON.create();
        json.put("templateUrl", partial.url());
        json.put("controller", controllerClass.getName());
        ngo.when(route, json);
        return this;
    }

    @Deprecated
    public <C extends Controller> RouteProvider when(String route, String templateUrl, Class<C> controllerClass) {
        JSON json = JSON.create();
        json.put("templateUrl", templateUrl);
        json.put("controller", controllerClass.getName());
        ngo.when(route, json);
        return this;
    }

    public RouteProvider when(String route, String redirectTo) {
        JSON redirect = JSON.create();
        redirect.put("redirectTo", redirectTo);
        ngo.when(route, redirect);
        return this;
    }

    public RouteProvider otherwise(String redirectTo) {
        JSON redirect = JSON.create();
        redirect.put("redirectTo", redirectTo);
        ngo.otherwise(redirect);
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
