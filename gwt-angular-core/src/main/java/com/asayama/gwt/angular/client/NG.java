package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.client.log.Log;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;

public class NG extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            ScriptInjector.fromString(AngularScripts.INSTANCE.js().getText())
                .setWindow(JSObject.$wnd).inject();
            Angular.module(this, "ng");
            factory(Q.class);
            factory(Location.class);
            factory(Log.class);
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }

}
