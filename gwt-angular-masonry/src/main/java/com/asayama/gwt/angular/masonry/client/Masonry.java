package com.asayama.gwt.angular.masonry.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.jsni.client.JSObject;
import com.asayama.gwt.resources.client.ScriptResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;


public class Masonry extends AbstractModule implements EntryPoint {

    private static final String CLASS = Masonry.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            MasonryModuleScripts scripts = GWT.create(MasonryModuleScripts.class);
            scripts.masonry().ensureInjected(JSObject.$wnd);
            scripts.angularMasonry().ensureInjected(JSObject.$wnd);
            Angular.module(this, "wu.masonry");
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Exception while " + m, e);
        }
    }
}

interface MasonryModuleScripts extends ClientBundle {
    
    @Source("bower_components/angular-masonry.js")
    ScriptResource masonry();

    @Source("bower_components/masonry/dist/masonry.pkgd.min.js")
    ScriptResource angularMasonry();
}