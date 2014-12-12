package com.asayama.gwt.angular.client.q;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.JavaScriptObject;


public class Deferred<V> extends JavaScriptObject {

    private static final String CLASS = Deferred.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS);
    
    protected Deferred() {
    }

    public final void resolve(V value) {
        try {
            _resolve(HostedModeEnvelope.wrap(value));
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Exception while resolving a value, value=" + value, e);
        }
    }
    
    public final void reject(Throwable reason) {
        try {
            _reject(HostedModeEnvelope.wrap(reason));
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Exception while rejecting a value", e);
        }
    }
    
    public final void progress(Progress progress) {
        try {
            _progress(HostedModeEnvelope.wrap(progress));
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Exception while notifying progress", e);
        }
    }
    
    public final native Promise<V> promise() /*-{
        return this.promise;
    }-*/;
    
    private final native void _resolve(HostedModeEnvelope<V> value) /*-{
        this.resolve(value);
    }-*/;
    
    private final native void _reject(HostedModeEnvelope<Throwable> value) /*-{
        this.reject(value);
    }-*/;
    
    private final native void _progress(HostedModeEnvelope<Progress> value) /*-{
        this.notify(value);
    }-*/;
}