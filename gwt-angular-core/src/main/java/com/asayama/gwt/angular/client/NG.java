package com.asayama.gwt.angular.client;

import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.client.log.Log;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.jsni.client.JSObject;
import com.asayama.gwt.resources.client.ScriptResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public class NG extends AbstractModule implements EntryPoint {
    
    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            NGScripts.INSTANCE.script().ensureInjected(JSObject.$wnd);
            Angular.moduleWithDependency(this, "ng");
            factory(com.asayama.gwt.angular.client.q.deprecated.Q.class);
            factory(Q.class);
            factory(Location.class);
            factory(Log.class);
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }
}

interface NGScripts extends ClientBundle {
    
    static NGScripts INSTANCE = GWT.create(NGScripts.class);
    
    @Source("angular.min.js")
    ScriptResource script();
}