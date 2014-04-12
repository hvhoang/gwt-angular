package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.jsni.client.JSObject;
import com.google.gwt.core.client.GWT;


public class Deferred<T> extends JSObject {

    protected Deferred() {
    }

    public final void resolve(T value) {
        try {
            _resolve(HostedModeEnvelope.wrap(value));
        } catch (Exception e) {
            GWT.log("Exception while resolving a value, value=" + value, e);
        }
    }
    
    public final void reject(Throwable value) {
        try {
            _reject(HostedModeEnvelope.wrap(value));
        } catch (Exception e) {
            GWT.log("Exception while rejecting a value", e);
        }
    }
    
    public final void notify(Object value) {
        try {
            _notify(HostedModeEnvelope.wrap(value));
        } catch (Exception e) {
            GWT.log("Exception while notifying progress", e);
        }
    }
    
    public final native Promise<T> promise() /*-{
        return this.promise;
    }-*/;
    
    public final native void _resolve(HostedModeEnvelope<T> value) /*-{
        this.resolve(value);
    }-*/;
    
    public final native void _reject(HostedModeEnvelope<Throwable> value) /*-{
        this.reject(value);
    }-*/;
    
    public final native void _notify(HostedModeEnvelope<Object> value) /*-{
        this.notify(value);
    }-*/;
}