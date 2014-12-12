package com.asayama.gwt.angular.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.location.Location;
import com.asayama.gwt.angular.client.log.Log;
import com.asayama.gwt.angular.client.q.Q;
import com.asayama.gwt.jsni.client.JSObject;
import com.asayama.gwt.resources.client.ScriptResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public class NG extends AbstractModule implements EntryPoint {
    
    private static final String CLASS = NG.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            NGScripts.INSTANCE.script().ensureInjected(JSObject.$wnd);
            Angular.moduleWithDependency(this, "ng");
            service(Q.class);
            service(Location.class);
            service(Log.class);
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Exception while " + m, e);
        }
    }
}

interface NGScripts extends ClientBundle {
    
    static NGScripts INSTANCE = GWT.create(NGScripts.class);
    
    @Source("bower_components/angular/angular.min.js")
    ScriptResource script();
}