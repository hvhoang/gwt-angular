package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.jsni.client.JSArray;
import com.asayama.gwt.jsni.client.JSObject;
import com.google.gwt.core.client.GWT;

/**
 * This JavaScriptObject type was defined to workaround the problem of passing
 * a plain old java object through AngularJS's promise pipeline. When primitive
 * and String objects were passed, the framework worked as expected. However,
 * when a user defined object, such as GWT's Response object, was passed, the
 * promise framework broke with null pointer exception in the code somewhere
 * for Hosted Mode only. (The same exact code worked in Prod Mode, just as 
 * expected.)
 * <p>
 * https://github.com/kyoken74/gwt-angular/issues/67
 * </p>
 * 
 * @author kyoken74
 */
class HostedModeEnvelope<P> extends JSObject {

    static <P> HostedModeEnvelope<P> wrap(P payload) {
        HostedModeEnvelope<P> envelope = JSObject.create();
        envelope.$object("payload", payload);
        return envelope;
    }
    
    @SuppressWarnings("unchecked")
    static <P> P unwrap(Object o) {
        if (o == null) {
            return null;
        }
        HostedModeEnvelope<P> envelope = (HostedModeEnvelope<P>) o;
        GWT.log(envelope.toJavaScript());
        P payload = envelope.getPayload();
        if (payload == null) {
            JSArray<?> array = envelope.cast();
            if (array.size() > 0) {
                JSArray<Object> results = JSArray.create();
                for (int i = 0; i < array.size(); i++) {
                    results.add( ((HostedModeEnvelope<?>) array.get(i)).getPayload() );
                }
                return (P) results;
            }
        }
        return payload;
    }
    
    protected HostedModeEnvelope() {
    }
    
    final P getPayload() {
        return $object("payload");
    }
}
