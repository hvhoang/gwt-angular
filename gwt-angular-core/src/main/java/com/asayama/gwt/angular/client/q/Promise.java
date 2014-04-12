package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.jsni.client.Function;
import com.asayama.gwt.jsni.client.JSFunction;
import com.asayama.gwt.jsni.client.JSObject;
import com.google.gwt.core.shared.GWT;


public class Promise<V> extends JSObject {
    
    protected Promise() {
    }

    public static interface Done<V> {
        void call(V value);
    }

    public static interface Continue<X, V> {
        X call(V value);
    }

    public static interface Fail {
        void call(Throwable cause);
    }

    public static interface Notify {
        void call(Progress progress);
    }

    public final <X> Promise<X> then(Continue<X, V> success) {
        return then(success, null, null);
    }

    public final Promise<V> then(Fail fail) {
        return then(null, fail, null);
    }
    
    public final Promise<V> then(Notify notify) {
        return then(null, null, notify);
    }
    
    public final Promise<V> then(final Done<V> success) {
        then(new Continue<Object, V>() {
            @Override
            public Object call(V value) {
                success.call(value);
                return null;
            }
        }, null, null);
        return this;
    }

    public final <X> Promise<X> then(final Continue<X, V> success, final Fail fail, final Notify notify) {
        Promise<X> p = _then(
                success == null ? null : JSFunction.create(new Function<Object>() {

                    @Override
                    public Object call(Object... args) {
                        try {
                            Object object = (args == null || args.length == 0) ? null : args[0];
                            V value = HostedModeEnvelope.unwrap(object);
                            return HostedModeEnvelope.wrap(success.call(value));
                        } catch (Throwable e) {
                            GWT.log("Exception while calling promise success", e);
                            return null; //FIXME
                        }
                    }
                }),
                fail == null ? null : JSFunction.create(new Function<Object>() {

                    @Override
                    public Object call(Object... args) {
                        try {
                            Object object = (args == null || args.length == 0) ? null : args[0];
                            Throwable value = HostedModeEnvelope.unwrap(object);
                            fail.call(value);
                            return HostedModeEnvelope.wrap(value);
                        } catch (Throwable e) {
                            GWT.log("Exception while calling promise fail", e);
                            return null; //FIXME
                        }
                    }
                }),
                notify == null ? null : JSFunction.create(new Function<Object>() {

                    @Override
                    public Object call(Object... args) {
                        try {
                            Object object = (args == null || args.length == 0) ? null : args[0];
                            Progress value = HostedModeEnvelope.unwrap(object);
                            notify.call(value);
                            return HostedModeEnvelope.wrap(value);
                        } catch (Throwable e) {
                            GWT.log("Exception while calling promise notify", e);
                            return null; //FIXME
                        }
                    }
                }));
        return p;
    }

    private final native <X> Promise<X> _then(JSFunction<?> fn1, JSFunction<?> fn2, JSFunction<?> fn3) /*-{
        return this.then(fn1, fn2, fn3);
    }-*/;
}
