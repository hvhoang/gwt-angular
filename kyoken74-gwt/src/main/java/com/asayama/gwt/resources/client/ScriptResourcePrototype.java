package com.asayama.gwt.resources.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.shared.GWT;


public class ScriptResourcePrototype implements ScriptResource {

    @Override
    public String getName() {
        String m = ScriptResourcePrototype.class.getName() + " should not be directly instantiated.";
        UnsupportedOperationException e = new UnsupportedOperationException(m);
        GWT.log(m, e);
        throw e;
    }

    public String getText() {
        String m = ScriptResourcePrototype.class.getName() + " should not be directly instantiated.";
        UnsupportedOperationException e = new UnsupportedOperationException(m);
        GWT.log(m, e);
        throw e;
    }

    @Override
    public boolean ensureInjected() {
        return ensureInjected(null);
    }

    @Override
    public boolean ensureInjected(JavaScriptObject wnd) {
        try {
            if (wnd == null) {
                ScriptInjector.fromString(getText()).inject();
            } else {
                ScriptInjector.fromString(getText()).setWindow(wnd).inject();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
