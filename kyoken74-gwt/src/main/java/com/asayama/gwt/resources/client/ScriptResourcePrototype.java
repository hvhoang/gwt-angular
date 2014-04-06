package com.asayama.gwt.resources.client;

import com.asayama.gwt.jsni.client.JSObject;
import com.google.gwt.core.client.ScriptInjector;


public class ScriptResourcePrototype implements ScriptResource {

    @Override
    public String getName() {
        return "";
    }

    public String getText() {
        return "";
    }

    @Override
    public boolean ensureInjected() {
        try {
            ScriptInjector.fromString(getText()).setWindow(JSObject.$wnd).inject();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
