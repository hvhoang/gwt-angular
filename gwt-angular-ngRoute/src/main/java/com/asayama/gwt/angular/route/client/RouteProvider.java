package com.asayama.gwt.angular.route.client;

import com.asayama.gwt.angular.client.Angular.Bind;
import com.asayama.gwt.angular.client.Controller;
import com.asayama.gwt.angular.client.Factory;
import com.asayama.gwt.angular.client.NGObject;
import com.asayama.gwt.angular.client.Provider;
import com.asayama.gwt.angular.client.Service;
import com.asayama.gwt.jsni.client.JSON;
import com.asayama.gwt.resources.client.HtmlResource;
import com.google.gwt.core.client.JavaScriptObject;

public class RouteProvider implements Provider<Service> {

    private NGRouteProvider ngo;

    @Override
    public Factory<Service> getFactory() {
    	// TODO Auto-generated method stub
    	return null;
    }
    
    public <C extends Controller> RouteProvider when(HtmlResource partial) {
        String route = "/" + partial.getName();
        return when(route, partial);
    }

    public <C extends Controller> RouteProvider when(HtmlResource partial, Class<C> controllerClass) {
        String route = "/" + partial.getName();
        return when(route, partial, controllerClass);
    }

    public <C extends Controller> RouteProvider when(String route, HtmlResource partial) {
        return when(route, partial, null);
    }
    
    public <C extends Controller> RouteProvider when(String route, HtmlResource partial, Class<C> controllerClass) {
        String templateUrl = partial.getSafeUri().asString();
        return when(route, templateUrl, controllerClass);
    }

    public <C extends Controller> RouteProvider when(String route, String templateUrl) {
        return when(route, templateUrl, null);
    }

    public <C extends Controller> RouteProvider when(String route, String templateUrl, Class<C> controllerClass) {
        JSON json = JSON.create();
        json.put("templateUrl", templateUrl);
        if (controllerClass != null) {
            json.put("controller", controllerClass.getName());
        }
        ngo.when(route, json);
        return this;
    }

    public RouteProvider redirect(String route, String redirectTo) {
        JSON redirect = JSON.create();
        redirect.put("redirectTo", redirectTo);
        ngo.when(route, redirect);
        return this;
    }

    public RouteProvider otherwise(HtmlResource partial) {
        String redirectTo = partial.getName();
        return otherwise(redirectTo);
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
