package com.asayama.gwt.angular.sanitize.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;

public class NGSanitize extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            ScriptInjector.fromString(AngularSanitizeScripts.INSTANCE.js().getText())
                .setWindow(JSObject.$wnd).inject();
            Angular.module(this, "ngSanitize");
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }

}
