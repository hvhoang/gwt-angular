package com.asayama.gwt.angular.prettify.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.angular.prettify.client.directive.GwtPrettify;
import com.asayama.gwt.angular.prettify.client.filter.Prettify;
import com.asayama.gwt.angular.prettify.client.resources.PrettifyScripts;
import com.asayama.gwt.jsni.client.JSObject;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.StyleInjector;

public class PrettifyModule extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        StyleInjector.inject(PrettifyScripts.INSTANCE.css().getText());
        ScriptInjector.fromString(PrettifyScripts.INSTANCE.js().getText())
            .setWindow(JSObject.$wnd).inject();
        Angular.module(this);
        filter(Prettify.class);
        directive(GwtPrettify.class);
    }
}
