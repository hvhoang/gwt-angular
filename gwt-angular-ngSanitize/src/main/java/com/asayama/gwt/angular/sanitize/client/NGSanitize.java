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
        NGScripts scripts = GWT.create(NGScripts.class);
        scripts.script().ensureInjected(JSObject.$wnd);
        Angular.module(this, "ngSanitize");
    }
}

interface NGScripts extends ClientBundle {
    
    @Source("bower_components/angular-sanitize/angular-sanitize.min.js")
    ScriptResource script();
}