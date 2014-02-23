package com.asayama.gwt.angular.route.client;

import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.client.Module;
import com.asayama.gwt.angular.client.annotations.Depends;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

@Depends("ngRoute")
public class NGRoute extends Module implements EntryPoint {

    static final String CLASS = NGRoute.class.getName();
    
    @Override
    public void onModuleLoad() {
        String m = "";
        try {
            GWT.log(m = "initializing " + CLASS);
            NGRoute module = Angular.module(this);
            module.factory(new RouteParams());
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }

}
