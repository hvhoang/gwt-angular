package com.asayama.gwt.resources.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.dom.client.StyleInjector;


public class StyleResourcePrototype implements StyleResource {

    private static final String CLASS = StyleResourcePrototype.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);
    
    @Override
    public String getName() {
        String m = StyleResourcePrototype.class.getName() + " should not be directly instantiated.";
        UnsupportedOperationException e = new UnsupportedOperationException(m);
        LOG.log(Level.WARNING, m, e);
        throw e;
    }

    public String getText() {
        String m = StyleResourcePrototype.class.getName() + " should not be directly instantiated.";
        UnsupportedOperationException e = new UnsupportedOperationException(m);
        LOG.log(Level.WARNING, m, e);
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
