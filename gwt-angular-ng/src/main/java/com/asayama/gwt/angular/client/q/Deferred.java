package com.asayama.gwt.angular.client.q;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;


public class Deferred<V> extends JavaScriptObject {

    protected Deferred() {
    }

    public final void resolve(V value) {
        try {
            _resolve(HostedModeEnvelope.wrap(value));
        } catch (Exception e) {
            GWT.log("Exception while resolving a value, value=" + value, e);
        }
    }
    
    public final void reject(Throwable reason) {
        try {
            _reject(HostedModeEnvelope.wrap(reason));
        } catch (Exception e) {
            GWT.log("Exception while rejecting a value", e);
        }
    }
    
    public final void progress(Progress progress) {
        try {
            _progress(HostedModeEnvelope.wrap(progress));
        } catch (Exception e) {
            GWT.log("Exception while notifying progress", e);
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