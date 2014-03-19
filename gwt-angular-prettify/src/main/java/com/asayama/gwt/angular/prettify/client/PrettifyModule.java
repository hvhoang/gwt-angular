package com.asayama.gwt.angular.prettify.client;

import com.asayama.gwt.angular.client.AbstractModule;
import com.asayama.gwt.angular.client.Angular;
import com.asayama.gwt.core.client.JSObject;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class PrettifyModule extends AbstractModule implements EntryPoint {

    @Override
    public void onModuleLoad() {
        StyleInjector.inject(PrettifyResources.INSTANCE.css().getText());
        ScriptInjector.fromString(PrettifyResources.INSTANCE.js().getText())
            .setWindow(JSObject.$wnd).inject();
        Angular.module(this);
        filter("prettyprint", new PrettyPrintFilter());
    }
}

interface PrettifyResources extends ClientBundle {
    
    static PrettifyResources INSTANCE = GWT.create(PrettifyResources.class);
    
    @Source("resources/prettify.css")
    TextResource css();

    @Source("resources/prettify.js")
    TextResource js();
}