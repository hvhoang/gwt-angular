package com.asayama.gwt.angular.route.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.jsni.client.JSObject;
import com.asayama.gwt.resources.client.ScriptResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public class NGRoute extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            NGScripts.INSTANCE.script().ensureInjected(JSObject.$wnd);
            Angular.moduleWithDependency(this, "ngRoute");
            service(RouteParams.class);
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }
}

interface NGScripts extends ClientBundle {
    
    static NGScripts INSTANCE = GWT.create(NGScripts.class);
    
    @Source("bower_components/angular-route/angular-route.min.js")
    ScriptResource script();
}
