package com.asayama.gwt.angular.prettify.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.prettify.client.directive.GwtPrettify;
import com.asayama.gwt.angular.prettify.client.directive.Prettyprint;
import com.asayama.gwt.jsni.client.JSObject;
import com.asayama.gwt.resources.client.ScriptResource;
import com.asayama.gwt.resources.client.StyleResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;

public class Prettify extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        PrettifyScripts.INSTANCE.css().ensureInjected();
        PrettifyScripts.INSTANCE.script().ensureInjected(JSObject.$wnd);
        Angular.module(this);
        filter(com.asayama.gwt.angular.prettify.client.filter.Prettify.class);
        directive(GwtPrettify.class);
        directive(Prettyprint.class);
    }
}

interface PrettifyScripts extends ClientBundle {
    
    static PrettifyScripts INSTANCE = GWT.create(PrettifyScripts.class);
    
    @Source("bower_components/google-code-prettify/bin/prettify.min.css")
    StyleResource css();

    @Source("bower_components/google-code-prettify/bin/prettify.min.js")
    ScriptResource script();
}
