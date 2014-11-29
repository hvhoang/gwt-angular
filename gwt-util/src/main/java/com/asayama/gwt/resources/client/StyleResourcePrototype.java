package com.asayama.gwt.resources.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.StyleInjector;


public class StyleResourcePrototype implements StyleResource {

    @Override
    public String getName() {
        String m = StyleResourcePrototype.class.getName() + " should not be directly instantiated.";
        UnsupportedOperationException e = new UnsupportedOperationException(m);
        GWT.log(m, e);
        throw e;
    }

    public String getText() {
        String m = StyleResourcePrototype.class.getName() + " should not be directly instantiated.";
        UnsupportedOperationException e = new UnsupportedOperationException(m);
        GWT.log(m, e);
        throw e;
    }

    @Override
    public boolean ensureInjected() {
        return ensureInjected(true);
    }

    @Override
    public boolean ensureInjected(boolean immediate) {
        try {
            StyleInjector.inject(getText(), immediate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
