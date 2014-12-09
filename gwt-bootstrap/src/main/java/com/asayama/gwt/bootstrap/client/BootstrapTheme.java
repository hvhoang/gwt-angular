package com.asayama.gwt.bootstrap.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public class BootstrapTheme implements EntryPoint {
    
    @Override
    public void onModuleLoad() {
        String m = "initializing " + getClass().getName();
        try {
//            BootstrapThemeScripts.INSTANCE.css().ensureInjected(true);
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
interface BootstrapThemeScripts extends ClientBundle {

    static BootstrapThemeScripts INSTANCE = GWT.create(BootstrapThemeScripts.class);

    // @Source("bower_components/bootstrap/dist/css/bootstrap-theme.min.css")
    // StyleResource css();
}
