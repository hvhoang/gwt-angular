package com.asayama.gwt.angular.animate.client;

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
 * GWT Angular animation module, analogous to AngularJS's {@code ngAnimate}. In
 * order to depend on this module, the user must inherit from this module in 
 * his gwt.xml.
 * 
 * <pre>
 * {@code <inherits name="com.asayama.gwt.angular.NGAnimate" />}
 * </pre>
 * 
 * This module automatically injects the angular JavaScript file.
 * 
 * @author kyoken74
 */
public class NGAnimate extends AbstractModule implements EntryPoint {

    private static final String CLASS = NGAnimate.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            NGScripts scripts = GWT.create(NGScripts.class);
            scripts.script().ensureInjected(JSObject.$wnd);
            Angular.module(this, "ngAnimate");
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Exception while " + m, e);
        }
    }
}

interface NGScripts extends ClientBundle {
    
    @Source("bower_components/angular-animate/angular-animate.min.js")
    ScriptResource script();
}
