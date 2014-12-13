package com.asayama.gwt.angular.sanitize.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.jsni.client.JSObject;
import com.asayama.gwt.resources.client.ScriptResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public class NGSanitize extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        NGScripts.INSTANCE.script().ensureInjected(JSObject.$wnd);
        Angular.module(this, "ngSanitize");
    }
}

interface NGScripts extends ClientBundle {
    
    static NGScripts INSTANCE = GWT.create(NGScripts.class);
    
    @Source("bower_components/angular-sanitize/angular-sanitize.min.js")
    ScriptResource script();
}