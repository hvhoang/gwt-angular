package com.asayama.gwt.angular.route.client;

import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Module;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class NGRoute extends Module implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "";
        try {
            GWT.log(m = "initializing " + getClass().getName());
            NGRoute module = Angular.module(this, "ngRoute");
            module.factory(new RouteParams());
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }

}
