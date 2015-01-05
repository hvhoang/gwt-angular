package com.asayama.gwt.angular.route.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.jsni.client.JSObject;
import com.asayama.gwt.resources.client.ScriptResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

/**
 * GWT Angular route module, analogous to AngularJS's {@code ngRoute}. In order
 * to depend on this module, the user must inherit from this module in his 
 * gwt.xml.
 * 
 * <pre>
 * {@code <inherits name="com.asayama.gwt.angular.NGRoute" />}
 * </pre>
 * 
 * This module automatically injects the angular JavaScript file.
 * 
 * @author kyoken74
 */
public class NGRoute extends AbstractModule implements EntryPoint {

    private static final String CLASS = NGRoute.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            NGScripts scripts = GWT.create(NGScripts.class);
            scripts.script().ensureInjected(JSObject.$wnd);
            Angular.module(this, "ngRoute");
            service(RouteParams.class);
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Exception while " + m, e);
        }
    }
}

interface NGScripts extends ClientBundle {
    
    @Source("bower_components/angular-route/angular-route.min.js")
    ScriptResource script();
}
