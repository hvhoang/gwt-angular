package com.asayama.gwt.angular.masonry.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.jsni.client.JSObject;
import com.asayama.gwt.resources.client.ScriptResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;


public class Masonry extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
            MasonryModuleScripts.INSTANCE.masonry().ensureInjected(JSObject.$wnd);
            MasonryModuleScripts.INSTANCE.angularMasonry().ensureInjected(JSObject.$wnd);
            Angular.moduleWithDependency(this, "wu.masonry");
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }
}

interface MasonryModuleScripts extends ClientBundle {
    
    static MasonryModuleScripts INSTANCE = GWT.create(MasonryModuleScripts.class);

    @Source("angular-masonry.js")
    ScriptResource masonry();

    @Source("masonry.pkgd.js")
    ScriptResource angularMasonry();
}