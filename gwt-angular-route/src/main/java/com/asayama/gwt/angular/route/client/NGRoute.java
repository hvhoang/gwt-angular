package com.asayama.gwt.angular.route.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.jsni.client.JSObject;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;

public class NGRoute extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            if (GWT.isClient() && GWT.isProdMode()) {
                ScriptInjector
                    .fromString(AngularRouteScripts.INSTANCE.min().getText())
                    .setWindow(JSObject.$wnd).inject();
            } else {
                ScriptInjector
                    .fromString(AngularRouteScripts.INSTANCE.debug().getText())
                    .setWindow(JSObject.$wnd).inject();
            }
            Angular.module(this, "ngRoute");
            factory(RouteParams.class);
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }

}
