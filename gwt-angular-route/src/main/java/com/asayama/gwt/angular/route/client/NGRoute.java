package com.asayama.gwt.angular.route.client;

import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Module;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


public class NGRoute extends Module implements EntryPoint {

    @Override
    public void onModuleLoad() {
        GWT.log("entering NGRoute.onModuleLoad()");
        NGRoute module = Angular.module(this);
        module.factory(new RouteParams());
    }

}
