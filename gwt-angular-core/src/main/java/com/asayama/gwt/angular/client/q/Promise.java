package com.asayama.gwt.angular.client.q;

import com.asayama.gwt.jsni.client.Function;
import com.asayama.gwt.jsni.client.JSFunction;
import com.asayama.gwt.jsni.client.JSObject;


public class Promise<V> extends JSObject {
    
    protected Promise() {
    }

    public static interface Done<V> {
        void call(V value);
    }

    public static interface Continue<X, V> {
        X call(V value);
    }

    public static interface Error<V> {
        void call(Throwable value);
    }

    public static interface Notify<V> {
        void call(Double value);
    }

    public final <X> Promise<X> then(Continue<X, V> success) {
        return then(success, null, null);
    }

    public final Promise<V> then(Error<V> error) {
        return then(null, error, null);
    }
    
    public final Promise<V> then(Notify<V> notify) {
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

    public final <X> Promise<X> then(final Continue<X, V> success, final Error<V> error, final Notify<V> notify) {
        Promise<X> p = _then(
                success == null ? null : JSFunction.create(new Function<Object>() {

                    @Override
                    public Object call(Object... args) {
                        if (args == null || args.length == 0) {
                            return success.call(null);
                        }
                        V value = HostedModeEnvelope.unwrap(args[0]);
                        return HostedModeEnvelope.wrap(success.call(value));
                    }
                }),
                error == null ? null : JSFunction.create(new Function<Object>() {

                    @Override
                    public Object call(Object... args) {
                        if (args == null || args.length == 0) {
                            error.call(null);
                            return this;
                        }
                        error.call((Throwable) args[0]);
                        return this;
                    }
                }),
                notify == null ? null : JSFunction.create(new Function<Object>() {

                    @Override
                    public Object call(Object... args) {
                        if (args == null || args.length == 0) {
                            notify.call(null);
                            return this;
                        }
                        notify.call((Double) args[0]);
                        return this;
                    }
                }));
        return p;
    }

    private final native <X> Promise<X> _then(JSFunction<?> success, JSFunction<?> error, JSFunction<?> notify) /*-{
        return this.then(success, error, notify);
    }-*/;
}
