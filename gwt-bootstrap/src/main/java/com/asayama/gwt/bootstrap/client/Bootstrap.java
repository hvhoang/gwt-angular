package com.asayama.gwt.bootstrap.client;

import com.asayama.gwt.jsni.client.JSObject;
import com.asayama.gwt.resources.client.ScriptResource;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public class Bootstrap implements EntryPoint {
    
    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
//            BootstrapScripts.INSTANCE.css().ensureInjected(true);
            BootstrapScripts.INSTANCE.script().ensureInjected(JSObject.$wnd);
        } catch (Exception e) {
            GWT.log("Exception while " + m, e);
        }
    }
}

/**
 * Usage:
 * <p>
 * {@code BootstrapScripts.INSTANCE.script().ensureInjected(JSObject.$wnd); }
 * </p>
 * 
 * @author kyoken74
 */
interface BootstrapScripts extends ClientBundle {

    static BootstrapScripts INSTANCE = GWT.create(BootstrapScripts.class);

    @Source("bower_components/bootstrap/dist/js/bootstrap.min.js")
    ScriptResource script();

//  @Source("bower_components/bootstrap/dist/css/bootstrap.min.css")
//  StyleResource css();
}
