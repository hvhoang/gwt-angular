package com.asayama.gwt.angular.prettify.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.prettify.client.directive.GoogleCodePrettify;
import com.asayama.gwt.angular.prettify.client.directive.GwtPrettify;
import com.asayama.gwt.angular.prettify.client.filter.Prettify;
import com.asayama.gwt.jsni.client.JSObject;
import com.asayama.gwt.resources.client.ScriptResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class PrettifyModule extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        StyleInjector.inject(PrettifyScripts.INSTANCE.css().getText());
        PrettifyScripts.INSTANCE.script().ensureInjected(JSObject.$wnd);
        Angular.module(this);
        filter(Prettify.class);
        directive(GwtPrettify.class);
        directive(GoogleCodePrettify.class);
    }
}

interface PrettifyScripts extends ClientBundle {
    
    static PrettifyScripts INSTANCE = GWT.create(PrettifyScripts.class);
    
    @Source("prettify.css")
    TextResource css();

    @Source("prettify.js")
    ScriptResource script();
}
